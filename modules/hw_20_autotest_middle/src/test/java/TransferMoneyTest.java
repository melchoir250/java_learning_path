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
import models.DepositTransferRequest;
import models.DepositTransferResponse;
import models.UserRole;
import requests.AdminCreateUserRequester;
import requests.CheckBalanceRequester;
import requests.CreateAccountRequester;
import requests.DepositRequester;
import requests.DepositTransferRequester;
import specs.RequestSpecs;
import specs.ResponseSpecs;

@DisplayName("POST /api/v1/accounts/transfer")
class TransferMoneyTest extends BaseTest {

  @ParameterizedTest()
  @MethodSource("positiveTransferAmounts")
  void shouldAcceptPositiveTransferAmount(double depositAmount, double transferAmount) {
    CreateUserRequest userRequest1 = CreateUserRequest.builder()
      .username(RandomData.getUsername())
      .password(RandomData.getPassword())
      .role(UserRole.USER.toString())
      .build();

    new AdminCreateUserRequester(
      RequestSpecs.adminSpec(),
      ResponseSpecs.entityWasCreated())
        .post(userRequest1);

    RequestSpecification userSpec1 = RequestSpecs.authAsUser(
      userRequest1.getUsername(), userRequest1.getPassword());

    CreateAccountResponse account1 = new CreateAccountRequester(
      userSpec1,
      ResponseSpecs.entityWasCreated())
        .post(new CreateAccountRequest())
        .extract()
        .as(CreateAccountResponse.class);

    new DepositRequester(
      userSpec1,
      ResponseSpecs.requestReturnsOK())
        .post(DepositRequest.builder()
          .id(account1.getId())
          .balance(depositAmount)
          .build());

    CreateUserRequest userRequest2 = CreateUserRequest.builder()
      .username(RandomData.getUsername())
      .password(RandomData.getPassword())
      .role(UserRole.USER.toString())
      .build();

    new AdminCreateUserRequester(
      RequestSpecs.adminSpec(),
      ResponseSpecs.entityWasCreated())
        .post(userRequest2);

    RequestSpecification userSpec2 = RequestSpecs.authAsUser(
      userRequest2.getUsername(), userRequest2.getPassword());

    CreateAccountResponse account2 = new CreateAccountRequester(
      userSpec2,
      ResponseSpecs.entityWasCreated())
        .post(new CreateAccountRequest())
        .extract()
        .as(CreateAccountResponse.class);

    DepositTransferResponse transfer = new DepositTransferRequester(
      userSpec1,
      ResponseSpecs.requestReturnsOK())
        .post(DepositTransferRequest.builder()
          .senderAccountId(account1.getId())
          .receiverAccountId(account2.getId())
          .amount(transferAmount)
          .build())
        .extract()
        .as(DepositTransferResponse.class);

    softly.assertThat(transfer.getMessage())
      .isEqualTo(DepositLimits.TRANSFER_SUCCESS_MESSAGE);
    softly.assertThat(transfer.getSenderAccountId())
      .isEqualTo(account1.getId());
    softly.assertThat(transfer.getReceiverAccountId())
      .isEqualTo(account2.getId());
    softly.assertThat(transfer.getAmount())
      .isEqualTo(transferAmount);

    CreateAccountResponse[] accounts1 = new CheckBalanceRequester(
      userSpec1,
      ResponseSpecs.requestReturnsOK())
        .get()
        .extract()
        .as(CreateAccountResponse[].class);

    softly.assertThat(Arrays.stream(accounts1)
      .filter(a -> a.getId() == account1.getId())
      .findFirst()
      .orElseThrow(() -> new AssertionError("Account not found: " + account1.getId()))
      .getBalance())
      .isEqualTo(depositAmount - transferAmount);

    CreateAccountResponse[] accounts2 = new CheckBalanceRequester(
      userSpec2,
      ResponseSpecs.requestReturnsOK())
        .get()
        .extract()
        .as(CreateAccountResponse[].class);

    softly.assertThat(Arrays.stream(accounts2)
      .filter(a -> a.getId() == account2.getId())
      .findFirst()
      .orElseThrow(() -> new AssertionError("Account not found: " + account2.getId()))
      .getBalance())
      .isEqualTo(transferAmount);
  }

  static Stream<Arguments> positiveTransferAmounts() {
    return Stream.of(
      Arguments.of(DepositLimits.STANDARD, DepositLimits.STANDARD_TRANSFER),
      Arguments.of(DepositLimits.STANDARD, DepositLimits.MIN));
  }

  @ParameterizedTest()
  @MethodSource("positiveMaxTransferAmounts")
  void shouldAcceptPositiveTransferAmountNearMax(double transferAmount) {
    CreateUserRequest userRequest1 = CreateUserRequest.builder()
      .username(RandomData.getUsername())
      .password(RandomData.getPassword())
      .role(UserRole.USER.toString())
      .build();

    new AdminCreateUserRequester(
      RequestSpecs.adminSpec(),
      ResponseSpecs.entityWasCreated())
        .post(userRequest1);

    RequestSpecification userSpec1 = RequestSpecs.authAsUser(
      userRequest1.getUsername(), userRequest1.getPassword());

    CreateAccountResponse account1 = new CreateAccountRequester(
      userSpec1,
      ResponseSpecs.entityWasCreated())
        .post(new CreateAccountRequest())
        .extract()
        .as(CreateAccountResponse.class);

    new DepositRequester(
      userSpec1,
      ResponseSpecs.requestReturnsOK())
        .post(DepositRequest.builder()
          .id(account1.getId())
          .balance(DepositLimits.MAX)
          .build());

    new DepositRequester(
      userSpec1,
      ResponseSpecs.requestReturnsOK())
        .post(DepositRequest.builder()
          .id(account1.getId())
          .balance(DepositLimits.MAX)
          .build());

    CreateUserRequest userRequest2 = CreateUserRequest.builder()
      .username(RandomData.getUsername())
      .password(RandomData.getPassword())
      .role(UserRole.USER.toString())
      .build();

    new AdminCreateUserRequester(
      RequestSpecs.adminSpec(),
      ResponseSpecs.entityWasCreated())
        .post(userRequest2);

    RequestSpecification userSpec2 = RequestSpecs.authAsUser(
      userRequest2.getUsername(), userRequest2.getPassword());

    CreateAccountResponse account2 = new CreateAccountRequester(
      userSpec2,
      ResponseSpecs.entityWasCreated())
        .post(new CreateAccountRequest())
        .extract()
        .as(CreateAccountResponse.class);

    double fundedBalance = DepositLimits.MAX * 2;

    DepositTransferResponse transfer = new DepositTransferRequester(
      userSpec1,
      ResponseSpecs.requestReturnsOK())
        .post(DepositTransferRequest.builder()
          .senderAccountId(account1.getId())
          .receiverAccountId(account2.getId())
          .amount(transferAmount)
          .build())
        .extract()
        .as(DepositTransferResponse.class);

    softly.assertThat(transfer.getMessage())
      .isEqualTo(DepositLimits.TRANSFER_SUCCESS_MESSAGE);
    softly.assertThat(transfer.getSenderAccountId())
      .isEqualTo(account1.getId());
    softly.assertThat(transfer.getReceiverAccountId())
      .isEqualTo(account2.getId());
    softly.assertThat(transfer.getAmount())
      .isEqualTo(transferAmount);

    CreateAccountResponse[] accounts1 = new CheckBalanceRequester(
      userSpec1,
      ResponseSpecs.requestReturnsOK())
        .get()
        .extract()
        .as(CreateAccountResponse[].class);

    softly.assertThat(Arrays.stream(accounts1)
      .filter(a -> a.getId() == account1.getId())
      .findFirst()
      .orElseThrow(() -> new AssertionError("Account not found: " + account1.getId()))
      .getBalance())
      .isEqualTo(fundedBalance - transferAmount);

    CreateAccountResponse[] accounts2 = new CheckBalanceRequester(
      userSpec2,
      ResponseSpecs.requestReturnsOK())
        .get()
        .extract()
        .as(CreateAccountResponse[].class);

    softly.assertThat(Arrays.stream(accounts2)
      .filter(a -> a.getId() == account2.getId())
      .findFirst()
      .orElseThrow(() -> new AssertionError("Account not found: " + account2.getId()))
      .getBalance())
      .isEqualTo(transferAmount);
  }

  static Stream<Arguments> positiveMaxTransferAmounts() {
    return Stream.of(
      Arguments.of(DepositLimits.TRANSFER_MAX),
      Arguments.of(DepositLimits.JUST_BELOW_TRANSFER_MAX));
  }

  @ParameterizedTest()
  @MethodSource("negativeTransferAmounts")
  void shouldRejectInvalidTransferAmount(double transferAmount) {
    CreateUserRequest userRequest1 = CreateUserRequest.builder()
      .username(RandomData.getUsername())
      .password(RandomData.getPassword())
      .role(UserRole.USER.toString())
      .build();

    new AdminCreateUserRequester(
      RequestSpecs.adminSpec(),
      ResponseSpecs.entityWasCreated())
        .post(userRequest1);

    RequestSpecification userSpec1 = RequestSpecs.authAsUser(
      userRequest1.getUsername(), userRequest1.getPassword());

    CreateAccountResponse account1 = new CreateAccountRequester(
      userSpec1,
      ResponseSpecs.entityWasCreated())
        .post(new CreateAccountRequest())
        .extract()
        .as(CreateAccountResponse.class);

    new DepositRequester(
      userSpec1,
      ResponseSpecs.requestReturnsOK())
        .post(DepositRequest.builder()
          .id(account1.getId())
          .balance(DepositLimits.STANDARD)
          .build());

    CreateUserRequest userRequest2 = CreateUserRequest.builder()
      .username(RandomData.getUsername())
      .password(RandomData.getPassword())
      .role(UserRole.USER.toString())
      .build();

    new AdminCreateUserRequester(
      RequestSpecs.adminSpec(),
      ResponseSpecs.entityWasCreated())
        .post(userRequest2);

    RequestSpecification userSpec2 = RequestSpecs.authAsUser(
      userRequest2.getUsername(), userRequest2.getPassword());

    CreateAccountResponse account2 = new CreateAccountRequester(
      userSpec2,
      ResponseSpecs.entityWasCreated())
        .post(new CreateAccountRequest())
        .extract()
        .as(CreateAccountResponse.class);

    new DepositTransferRequester(
      userSpec1,
      ResponseSpecs.requestReturnsBadRequest())
        .post(DepositTransferRequest.builder()
          .senderAccountId(account1.getId())
          .receiverAccountId(account2.getId())
          .amount(transferAmount)
          .build());

    CreateAccountResponse[] accounts1 = new CheckBalanceRequester(
      userSpec1,
      ResponseSpecs.requestReturnsOK())
        .get()
        .extract()
        .as(CreateAccountResponse[].class);

    softly.assertThat(Arrays.stream(accounts1)
      .filter(a -> a.getId() == account1.getId())
      .findFirst()
      .orElseThrow(() -> new AssertionError("Account not found: " + account1.getId()))
      .getBalance())
      .isEqualTo(DepositLimits.STANDARD);

    CreateAccountResponse[] accounts2 = new CheckBalanceRequester(
      userSpec2,
      ResponseSpecs.requestReturnsOK())
        .get()
        .extract()
        .as(CreateAccountResponse[].class);

    softly.assertThat(Arrays.stream(accounts2)
      .filter(a -> a.getId() == account2.getId())
      .findFirst()
      .orElseThrow(() -> new AssertionError("Account not found: " + account2.getId()))
      .getBalance())
      .isEqualTo(0);
  }

  static Stream<Arguments> negativeTransferAmounts() {
    return Stream.of(
      Arguments.of(DepositLimits.ZERO),
      Arguments.of(DepositLimits.NEGATIVE));
  }

  @Test
  void shouldRejectTransferAboveMaximumLimit() {
    CreateUserRequest userRequest1 = CreateUserRequest.builder()
      .username(RandomData.getUsername())
      .password(RandomData.getPassword())
      .role(UserRole.USER.toString())
      .build();

    new AdminCreateUserRequester(
      RequestSpecs.adminSpec(),
      ResponseSpecs.entityWasCreated())
        .post(userRequest1);

    RequestSpecification userSpec1 = RequestSpecs.authAsUser(
      userRequest1.getUsername(), userRequest1.getPassword());

    CreateAccountResponse account1 = new CreateAccountRequester(
      userSpec1,
      ResponseSpecs.entityWasCreated())
        .post(new CreateAccountRequest())
        .extract()
        .as(CreateAccountResponse.class);

    new DepositRequester(
      userSpec1,
      ResponseSpecs.requestReturnsOK())
        .post(DepositRequest.builder()
          .id(account1.getId())
          .balance(DepositLimits.MAX)
          .build());

    new DepositRequester(
      userSpec1,
      ResponseSpecs.requestReturnsOK())
        .post(DepositRequest.builder()
          .id(account1.getId())
          .balance(DepositLimits.MAX)
          .build());

    new DepositRequester(
      userSpec1,
      ResponseSpecs.requestReturnsOK())
        .post(DepositRequest.builder()
          .id(account1.getId())
          .balance(DepositLimits.MAX)
          .build());

    CreateUserRequest userRequest2 = CreateUserRequest.builder()
      .username(RandomData.getUsername())
      .password(RandomData.getPassword())
      .role(UserRole.USER.toString())
      .build();

    new AdminCreateUserRequester(
      RequestSpecs.adminSpec(),
      ResponseSpecs.entityWasCreated())
        .post(userRequest2);

    RequestSpecification userSpec2 = RequestSpecs.authAsUser(
      userRequest2.getUsername(), userRequest2.getPassword());

    CreateAccountResponse account2 = new CreateAccountRequester(
      userSpec2,
      ResponseSpecs.entityWasCreated())
        .post(new CreateAccountRequest())
        .extract()
        .as(CreateAccountResponse.class);

    double fundedBalance = DepositLimits.MAX * 3;

    new DepositTransferRequester(
      userSpec1,
      ResponseSpecs.requestReturnsBadRequest())
        .post(DepositTransferRequest.builder()
          .senderAccountId(account1.getId())
          .receiverAccountId(account2.getId())
          .amount(DepositLimits.ABOVE_TRANSFER_MAX)
          .build());

    CreateAccountResponse[] accounts1 = new CheckBalanceRequester(
      userSpec1,
      ResponseSpecs.requestReturnsOK())
        .get()
        .extract()
        .as(CreateAccountResponse[].class);

    softly.assertThat(Arrays.stream(accounts1)
      .filter(a -> a.getId() == account1.getId())
      .findFirst()
      .orElseThrow(() -> new AssertionError("Account not found: " + account1.getId()))
      .getBalance())
      .isEqualTo(fundedBalance);

    CreateAccountResponse[] accounts2 = new CheckBalanceRequester(
      userSpec2,
      ResponseSpecs.requestReturnsOK())
        .get()
        .extract()
        .as(CreateAccountResponse[].class);

    softly.assertThat(Arrays.stream(accounts2)
      .filter(a -> a.getId() == account2.getId())
      .findFirst()
      .orElseThrow(() -> new AssertionError("Account not found: " + account2.getId()))
      .getBalance())
      .isEqualTo(0);
  }
}
