package requests.steps;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import io.restassured.specification.RequestSpecification;
import models.CreateAccountResponse;
import models.CreateUserRequest;
import models.CustomerProfile;
import models.DepositRequest;
import models.DepositResponse;
import models.DepositTransferRequest;
import models.DepositTransferResponse;
import models.UpdateProfileNameRequest;
import models.UpdateProfileNameResponse;
import requests.skelethon.Endpoint;
import requests.skelethon.requesters.CrudRequester;
import requests.skelethon.requesters.ValidatedCrudRequester;
import specs.RequestSpecs;
import specs.ResponseSpecs;

public final class UserSteps {
  private UserSteps() {}

  public static RequestSpecification authAs(CreateUserRequest user) {
    return RequestSpecs.authAsUser(user.getUsername(), user.getPassword());
  }

  public static CreateAccountResponse createAccount(RequestSpecification userSpec) {
    return new ValidatedCrudRequester<CreateAccountResponse>(
      userSpec,
      Endpoint.CREATE_ACCOUNT,
      ResponseSpecs.entityWasCreated())
        .post(null);
  }

  public static DepositRequest depositRequest(int accountId, double amount) {
    return DepositRequest.builder()
      .id(accountId)
      .balance(amount)
      .build();
  }

  public static DepositResponse deposit(RequestSpecification userSpec, DepositRequest request) {
    return new ValidatedCrudRequester<DepositResponse>(
      userSpec,
      Endpoint.DEPOSIT,
      ResponseSpecs.requestReturnsOK())
        .post(request);
  }

  public static DepositResponse deposit(
    RequestSpecification userSpec,
    int accountId,
    double amount) {
    return deposit(userSpec, depositRequest(accountId, amount));
  }

  public static void depositExpectingBadRequest(
    RequestSpecification userSpec,
    DepositRequest request,
    String expectedError) {
    new CrudRequester(
      userSpec,
      Endpoint.DEPOSIT,
      ResponseSpecs.requestReturnsBadRequestWithMessage(expectedError))
        .post(request);
  }

  public static void depositExpectingForbidden(
    RequestSpecification userSpec,
    DepositRequest request,
    String expectedError) {
    new CrudRequester(
      userSpec,
      Endpoint.DEPOSIT,
      ResponseSpecs.requestReturnsForbiddenWithMessage(expectedError))
        .post(request);
  }

  public static void depositExpectingUnauthorized(DepositRequest request) {
    new CrudRequester(
      RequestSpecs.unauthSpec(),
      Endpoint.DEPOSIT,
      ResponseSpecs.requestReturnsUnauthorized())
        .post(request);
  }

  public static DepositTransferRequest transferRequest(
    int senderAccountId,
    int receiverAccountId,
    double amount) {
    return DepositTransferRequest.builder()
      .senderAccountId(senderAccountId)
      .receiverAccountId(receiverAccountId)
      .amount(amount)
      .build();
  }

  public static DepositTransferResponse transfer(
    RequestSpecification userSpec,
    DepositTransferRequest request) {
    return new ValidatedCrudRequester<DepositTransferResponse>(
      userSpec,
      Endpoint.TRANSFER,
      ResponseSpecs.requestReturnsOKWithMessage("Transfer successful"))
        .post(request);
  }

  public static DepositTransferResponse transfer(
    RequestSpecification userSpec,
    int senderAccountId,
    int receiverAccountId,
    double amount) {
    return transfer(userSpec, transferRequest(senderAccountId, receiverAccountId, amount));
  }

  public static void transferExpectingBadRequest(
    RequestSpecification userSpec,
    DepositTransferRequest request) {
    new CrudRequester(
      userSpec,
      Endpoint.TRANSFER,
      ResponseSpecs.requestReturnsBadRequest())
        .post(request);
  }

  public static CreateAccountResponse[] getAccounts(RequestSpecification userSpec) {
    return new CrudRequester(
      userSpec,
      Endpoint.CUSTOMER_ACCOUNTS,
      ResponseSpecs.requestReturnsOK())
        .get()
        .extract()
        .as(CreateAccountResponse[].class);
  }

  public static void assertAccountBalance(
    RequestSpecification userSpec,
    int accountId,
    double expectedBalance) {
    double actualBalance = Arrays.stream(getAccounts(userSpec))
      .filter(account -> account.getId() == accountId)
      .findFirst()
      .orElseThrow(() -> new AssertionError("Account not found: " + accountId))
      .getBalance();

    Assertions.assertThat(actualBalance)
      .as("Balance of account %s via GET /customer/accounts", accountId)
      .isEqualTo(expectedBalance);
  }

  public static CustomerProfile getProfile(RequestSpecification userSpec) {
    return new ValidatedCrudRequester<CustomerProfile>(
      userSpec,
      Endpoint.GET_PROFILE,
      ResponseSpecs.requestReturnsOK())
        .get();
  }

  public static UpdateProfileNameRequest updateProfileNameRequest(String name) {
    return UpdateProfileNameRequest.builder()
      .name(name)
      .build();
  }

  public static UpdateProfileNameResponse updateProfileName(
    RequestSpecification userSpec,
    UpdateProfileNameRequest request) {
    return new ValidatedCrudRequester<UpdateProfileNameResponse>(
      userSpec,
      Endpoint.UPDATE_PROFILE,
      ResponseSpecs.requestReturnsOKWithMessage("Profile updated successfully"))
        .put(request);
  }

  public static void updateProfileNameExpectingBadRequest(
    RequestSpecification userSpec,
    UpdateProfileNameRequest request) {
    new CrudRequester(
      userSpec,
      Endpoint.UPDATE_PROFILE,
      ResponseSpecs.requestReturnsBadRequest())
        .put(request);
  }

  public static void assertProfile(
    RequestSpecification userSpec,
    String expectedUsername,
    String expectedName) {
    CustomerProfile profile = getProfile(userSpec);

    Assertions.assertThat(profile.getUsername())
      .as("Profile username via GET /customer/profile")
      .isEqualTo(expectedUsername);
    Assertions.assertThat(profile.getName())
      .as("Profile name via GET /customer/profile")
      .isEqualTo(expectedName);
  }
}
