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
    CreateUserRequest userRequest1 = createUserRequest();
    createUser(userRequest1);
    RequestSpecification userSpec1 = authAsUser(userRequest1);
    CreateAccountResponse account1 = createAccount(userSpec1);
    deposit(userSpec1, account1.getId(), depositAmount);

    CreateUserRequest userRequest2 = createUserRequest();
    createUser(userRequest2);
    RequestSpecification userSpec2 = authAsUser(userRequest2);
    CreateAccountResponse account2 = createAccount(userSpec2);

    DepositTransferResponse transfer = transfer(
      userSpec1, account1.getId(), account2.getId(), transferAmount);

    softly.assertThat(transfer.getMessage())
      .isEqualTo(DepositLimits.TRANSFER_SUCCESS_MESSAGE);
    softly.assertThat(transfer.getSenderAccountId())
      .isEqualTo(account1.getId());
    softly.assertThat(transfer.getReceiverAccountId())
      .isEqualTo(account2.getId());
    softly.assertThat(transfer.getAmount())
      .isEqualTo(transferAmount);

    assertBalance(userSpec1, account1.getId(), depositAmount - transferAmount);
    assertBalance(userSpec2, account2.getId(), transferAmount);
  }

  static Stream<Arguments> positiveTransferAmounts() {
    return Stream.of(
      Arguments.of(DepositLimits.STANDARD, DepositLimits.STANDARD_TRANSFER),
      Arguments.of(DepositLimits.STANDARD, DepositLimits.MIN));
  }

  @ParameterizedTest()
  @MethodSource("positiveMaxTransferAmounts")
  void shouldAcceptPositiveTransferAmountNearMax(double transferAmount) {
    CreateUserRequest userRequest1 = createUserRequest();
    createUser(userRequest1);
    RequestSpecification userSpec1 = authAsUser(userRequest1);
    CreateAccountResponse account1 = createAccount(userSpec1);
    deposit(userSpec1, account1.getId(), DepositLimits.MAX);
    deposit(userSpec1, account1.getId(), DepositLimits.MAX);

    CreateUserRequest userRequest2 = createUserRequest();
    createUser(userRequest2);
    RequestSpecification userSpec2 = authAsUser(userRequest2);
    CreateAccountResponse account2 = createAccount(userSpec2);

    double fundedBalance = DepositLimits.MAX * 2;
    DepositTransferResponse transfer = transfer(
      userSpec1, account1.getId(), account2.getId(), transferAmount);

    softly.assertThat(transfer.getMessage())
      .isEqualTo(DepositLimits.TRANSFER_SUCCESS_MESSAGE);
    softly.assertThat(transfer.getSenderAccountId())
      .isEqualTo(account1.getId());
    softly.assertThat(transfer.getReceiverAccountId())
      .isEqualTo(account2.getId());
    softly.assertThat(transfer.getAmount())
      .isEqualTo(transferAmount);

    assertBalance(userSpec1, account1.getId(), fundedBalance - transferAmount);
    assertBalance(userSpec2, account2.getId(), transferAmount);
  }

  static Stream<Arguments> positiveMaxTransferAmounts() {
    return Stream.of(
      Arguments.of(DepositLimits.TRANSFER_MAX),
      Arguments.of(DepositLimits.JUST_BELOW_TRANSFER_MAX));
  }

  @ParameterizedTest()
  @MethodSource("negativeTransferAmounts")
  void shouldRejectInvalidTransferAmount(double transferAmount) {
    CreateUserRequest userRequest1 = createUserRequest();
    createUser(userRequest1);
    RequestSpecification userSpec1 = authAsUser(userRequest1);
    CreateAccountResponse account1 = createAccount(userSpec1);
    deposit(userSpec1, account1.getId(), DepositLimits.STANDARD);

    CreateUserRequest userRequest2 = createUserRequest();
    createUser(userRequest2);
    RequestSpecification userSpec2 = authAsUser(userRequest2);
    CreateAccountResponse account2 = createAccount(userSpec2);

    new DepositTransferRequester(
      userSpec1,
      ResponseSpecs.requestReturnsBadRequest())
        .post(DepositTransferRequest.builder()
          .senderAccountId(account1.getId())
          .receiverAccountId(account2.getId())
          .amount(transferAmount)
          .build());

    assertBalance(userSpec1, account1.getId(), DepositLimits.STANDARD);
    assertBalance(userSpec2, account2.getId(), 0);
  }

  static Stream<Arguments> negativeTransferAmounts() {
    return Stream.of(
      Arguments.of(DepositLimits.ZERO),
      Arguments.of(DepositLimits.NEGATIVE));
  }

  @Test
  void shouldRejectTransferAboveMaximumLimit() {
    CreateUserRequest userRequest1 = createUserRequest();
    createUser(userRequest1);
    RequestSpecification userSpec1 = authAsUser(userRequest1);
    CreateAccountResponse account1 = createAccount(userSpec1);
    deposit(userSpec1, account1.getId(), DepositLimits.MAX);
    deposit(userSpec1, account1.getId(), DepositLimits.MAX);
    deposit(userSpec1, account1.getId(), DepositLimits.MAX);

    CreateUserRequest userRequest2 = createUserRequest();
    createUser(userRequest2);
    RequestSpecification userSpec2 = authAsUser(userRequest2);
    CreateAccountResponse account2 = createAccount(userSpec2);

    double fundedBalance = DepositLimits.MAX * 3;

    new DepositTransferRequester(
      userSpec1,
      ResponseSpecs.requestReturnsBadRequest())
        .post(DepositTransferRequest.builder()
          .senderAccountId(account1.getId())
          .receiverAccountId(account2.getId())
          .amount(DepositLimits.ABOVE_TRANSFER_MAX)
          .build());

    assertBalance(userSpec1, account1.getId(), fundedBalance);
    assertBalance(userSpec2, account2.getId(), 0);
  }

  private CreateUserRequest createUserRequest() {
    return CreateUserRequest.builder()
      .username(RandomData.getUsername())
      .password(RandomData.getPassword())
      .role(UserRole.USER.toString())
      .build();
  }

  private void createUser(CreateUserRequest userRequest) {
    new AdminCreateUserRequester(
      RequestSpecs.adminSpec(),
      ResponseSpecs.entityWasCreated())
        .post(userRequest);
  }

  private RequestSpecification authAsUser(CreateUserRequest userRequest) {
    return RequestSpecs.authAsUser(userRequest.getUsername(), userRequest.getPassword());
  }

  private CreateAccountResponse createAccount(RequestSpecification userSpec) {
    return new CreateAccountRequester(
      userSpec,
      ResponseSpecs.entityWasCreated())
        .post(new CreateAccountRequest())
        .extract()
        .as(CreateAccountResponse.class);
  }

  private void deposit(RequestSpecification userSpec, int accountId, double amount) {
    new DepositRequester(
      userSpec,
      ResponseSpecs.requestReturnsOK())
        .post(DepositRequest.builder()
          .id(accountId)
          .balance(amount)
          .build());
  }

  private DepositTransferResponse transfer(
    RequestSpecification userSpec,
    int senderAccountId,
    int receiverAccountId,
    double amount) {
    return new DepositTransferRequester(
      userSpec,
      ResponseSpecs.requestReturnsOK())
        .post(DepositTransferRequest.builder()
          .senderAccountId(senderAccountId)
          .receiverAccountId(receiverAccountId)
          .amount(amount)
          .build())
        .extract()
        .as(DepositTransferResponse.class);
  }

  private void assertBalance(RequestSpecification userSpec, int accountId, double expectedBalance) {
    CreateAccountResponse[] accounts = new CheckBalanceRequester(
      userSpec,
      ResponseSpecs.requestReturnsOK())
        .get()
        .extract()
        .as(CreateAccountResponse[].class);

    softly.assertThat(balanceOf(accounts, accountId))
      .isEqualTo(expectedBalance);
  }

  private double balanceOf(CreateAccountResponse[] accounts, int accountId) {
    return Arrays.stream(accounts)
      .filter(account -> account.getId() == accountId)
      .findFirst()
      .orElseThrow(() -> new AssertionError("Account not found: " + accountId))
      .getBalance();
  }
}
