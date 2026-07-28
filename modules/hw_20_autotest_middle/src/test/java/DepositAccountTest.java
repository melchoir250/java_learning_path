import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import constants.DepositLimits;
import generators.RandomData;
import io.restassured.specification.RequestSpecification;
import models.CreateAccountRequest;
import models.CreateAccountResponse;
import models.CreateUserRequest;
import models.DepositRequest;
import models.DepositResponse;
import models.UserRole;
import requests.AdminCreateUserRequester;
import requests.CheckBalanceRequester;
import requests.CreateAccountRequester;
import requests.DepositRequester;
import specs.RequestSpecs;
import specs.ResponseSpecs;

@DisplayName("POST /api/v1/accounts/deposit")
class DepositAccountTest extends BaseTest {

  @ParameterizedTest()
  @MethodSource("positiveDepositAmounts")
  void shouldAcceptPositiveDepositAmount(double depositAmount) {
    CreateUserRequest userRequest = CreateUserRequest.builder()
      .username(RandomData.getUsername())
      .password(RandomData.getPassword())
      .role(UserRole.USER.toString())
      .build();

    new AdminCreateUserRequester(
      RequestSpecs.adminSpec(),
      ResponseSpecs.entityWasCreated())
        .post(userRequest);

    RequestSpecification userSpec = RequestSpecs.authAsUser(
      userRequest.getUsername(), userRequest.getPassword());

    CreateAccountResponse account = new CreateAccountRequester(
      userSpec,
      ResponseSpecs.entityWasCreated())
        .post(new CreateAccountRequest())
        .extract()
        .as(CreateAccountResponse.class);

    DepositRequest depositRequest = DepositRequest.builder()
      .id(account.getId())
      .balance(depositAmount)
      .build();

    DepositResponse deposit = new DepositRequester(
      userSpec,
      ResponseSpecs.requestReturnsOK())
        .post(depositRequest)
        .extract()
        .as(DepositResponse.class);

    softly.assertThat(deposit.getBalance())
      .isEqualTo(depositAmount);
    softly.assertThat(deposit.getId())
      .isEqualTo(account.getId());
    softly.assertThat(deposit.getAccountNumber())
      .isEqualTo(account.getAccountNumber());
    softly.assertThat(deposit.getTransactions())
      .isNotEmpty();

    CreateAccountResponse[] accounts = new CheckBalanceRequester(
      userSpec,
      ResponseSpecs.requestReturnsOK())
        .get()
        .extract()
        .as(CreateAccountResponse[].class);

    softly.assertThat(Arrays.stream(accounts)
      .filter(a -> a.getId() == account.getId())
      .findFirst()
      .orElseThrow(() -> new AssertionError("Account not found: " + account.getId()))
      .getBalance())
      .isEqualTo(depositAmount);
  }

  static Stream<Arguments> positiveDepositAmounts() {
    return Stream.of(
      Arguments.of(DepositLimits.STANDARD),
      Arguments.of(DepositLimits.WITH_CENTS),
      Arguments.of(DepositLimits.MIN),
      Arguments.of(DepositLimits.MAX),
      Arguments.of(DepositLimits.JUST_BELOW_MAX));
  }

  @ParameterizedTest()
  @MethodSource("negativeDepositAmounts")
  void shouldRejectInvalidDepositAmount(double depositAmount, String expectedError) {
    CreateUserRequest userRequest = CreateUserRequest.builder()
      .username(RandomData.getUsername())
      .password(RandomData.getPassword())
      .role(UserRole.USER.toString())
      .build();

    new AdminCreateUserRequester(
      RequestSpecs.adminSpec(),
      ResponseSpecs.entityWasCreated())
        .post(userRequest);

    RequestSpecification userSpec = RequestSpecs.authAsUser(
      userRequest.getUsername(), userRequest.getPassword());

    CreateAccountResponse account = new CreateAccountRequester(
      userSpec,
      ResponseSpecs.entityWasCreated())
        .post(new CreateAccountRequest())
        .extract()
        .as(CreateAccountResponse.class);

    DepositRequest depositRequest = DepositRequest.builder()
      .id(account.getId())
      .balance(depositAmount)
      .build();

    new DepositRequester(
      userSpec,
      ResponseSpecs.requestReturnsBadRequestWithMessage(expectedError))
        .post(depositRequest);

    CreateAccountResponse[] accounts = new CheckBalanceRequester(
      userSpec,
      ResponseSpecs.requestReturnsOK())
        .get()
        .extract()
        .as(CreateAccountResponse[].class);

    softly.assertThat(Arrays.stream(accounts)
      .filter(a -> a.getId() == account.getId())
      .findFirst()
      .orElseThrow(() -> new AssertionError("Account not found: " + account.getId()))
      .getBalance())
      .isEqualTo(0);
  }

  static Stream<Arguments> negativeDepositAmounts() {
    return Stream.of(
      Arguments.of(DepositLimits.NEGATIVE, DepositLimits.MIN_AMOUNT_ERROR),
      Arguments.of(DepositLimits.ZERO, DepositLimits.MIN_AMOUNT_ERROR),
      Arguments.of(DepositLimits.ABOVE_MAX, DepositLimits.MAX_AMOUNT_ERROR));
  }

  @Test
  void shouldRejectDepositToNonExistingAccount() {
    CreateUserRequest userRequest = CreateUserRequest.builder()
      .username(RandomData.getUsername())
      .password(RandomData.getPassword())
      .role(UserRole.USER.toString())
      .build();

    new AdminCreateUserRequester(
      RequestSpecs.adminSpec(),
      ResponseSpecs.entityWasCreated())
        .post(userRequest);

    RequestSpecification userSpec = RequestSpecs.authAsUser(
      userRequest.getUsername(), userRequest.getPassword());

    CreateAccountResponse ownAccount = new CreateAccountRequester(
      userSpec,
      ResponseSpecs.entityWasCreated())
        .post(new CreateAccountRequest())
        .extract()
        .as(CreateAccountResponse.class);

    DepositRequest depositRequest = DepositRequest.builder()
      .id(DepositLimits.NON_EXISTING_ACCOUNT_ID)
      .balance(DepositLimits.STANDARD)
      .build();

    new DepositRequester(
      userSpec,
      ResponseSpecs.requestReturnsForbiddenWithMessage(DepositLimits.UNAUTHORIZED_ACCOUNT_ERROR))
        .post(depositRequest);

    CreateAccountResponse[] accounts = new CheckBalanceRequester(
      userSpec,
      ResponseSpecs.requestReturnsOK())
        .get()
        .extract()
        .as(CreateAccountResponse[].class);

    softly.assertThat(Arrays.stream(accounts)
      .filter(a -> a.getId() == ownAccount.getId())
      .findFirst()
      .orElseThrow(() -> new AssertionError("Account not found: " + ownAccount.getId()))
      .getBalance())
      .isEqualTo(0);
  }

  @Test
  void shouldRejectDepositWithoutAuthorization() {
    CreateUserRequest userRequest = CreateUserRequest.builder()
      .username(RandomData.getUsername())
      .password(RandomData.getPassword())
      .role(UserRole.USER.toString())
      .build();

    new AdminCreateUserRequester(
      RequestSpecs.adminSpec(),
      ResponseSpecs.entityWasCreated())
        .post(userRequest);

    RequestSpecification userSpec = RequestSpecs.authAsUser(
      userRequest.getUsername(), userRequest.getPassword());

    CreateAccountResponse account = new CreateAccountRequester(
      userSpec,
      ResponseSpecs.entityWasCreated())
        .post(new CreateAccountRequest())
        .extract()
        .as(CreateAccountResponse.class);

    DepositRequest depositRequest = DepositRequest.builder()
      .id(account.getId())
      .balance(DepositLimits.STANDARD)
      .build();

    new DepositRequester(
      RequestSpecs.unauthSpec(),
      ResponseSpecs.requestReturnsUnauthorized())
        .post(depositRequest);

    CreateAccountResponse[] accounts = new CheckBalanceRequester(
      userSpec,
      ResponseSpecs.requestReturnsOK())
        .get()
        .extract()
        .as(CreateAccountResponse[].class);

    softly.assertThat(Arrays.stream(accounts)
      .filter(a -> a.getId() == account.getId())
      .findFirst()
      .orElseThrow(() -> new AssertionError("Account not found: " + account.getId()))
      .getBalance())
      .isEqualTo(0);
  }
}
