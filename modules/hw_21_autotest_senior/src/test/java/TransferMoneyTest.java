import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import constants.DepositLimits;
import io.restassured.specification.RequestSpecification;
import models.CreateAccountResponse;
import models.CreateUserRequest;
import models.DepositTransferRequest;
import models.DepositTransferResponse;
import models.comparison.ModelAssertions;
import requests.steps.AdminSteps;
import requests.steps.UserSteps;

@DisplayName("POST /api/v1/accounts/transfer")
class TransferMoneyTest extends BaseTest {

  @ParameterizedTest()
  @MethodSource("positiveTransferAmounts")
  void shouldAcceptPositiveTransferAmount(double depositAmount, double transferAmount) {
    CreateUserRequest user1 = AdminSteps.createUser();
    RequestSpecification userSpec1 = UserSteps.authAs(user1);
    CreateAccountResponse account1 = UserSteps.createAccount(userSpec1);
    UserSteps.deposit(userSpec1, account1.getId(), depositAmount);

    CreateUserRequest user2 = AdminSteps.createUser();
    RequestSpecification userSpec2 = UserSteps.authAs(user2);
    CreateAccountResponse account2 = UserSteps.createAccount(userSpec2);

    DepositTransferRequest transferRequest = UserSteps.transferRequest(
      account1.getId(), account2.getId(), transferAmount);
    DepositTransferResponse transfer = UserSteps.transfer(userSpec1, transferRequest);

    ModelAssertions.assertThatModels(transferRequest, transfer)
      .match();

    UserSteps.assertAccountBalance(userSpec1, account1.getId(), depositAmount - transferAmount);
    UserSteps.assertAccountBalance(userSpec2, account2.getId(), transferAmount);
  }

  static Stream<Arguments> positiveTransferAmounts() {
    return Stream.of(
      Arguments.of(DepositLimits.STANDARD, DepositLimits.STANDARD_TRANSFER),
      Arguments.of(DepositLimits.STANDARD, DepositLimits.MIN));
  }

  @ParameterizedTest()
  @MethodSource("positiveMaxTransferAmounts")
  void shouldAcceptPositiveTransferAmountNearMax(double transferAmount) {
    CreateUserRequest user1 = AdminSteps.createUser();
    RequestSpecification userSpec1 = UserSteps.authAs(user1);
    CreateAccountResponse account1 = UserSteps.createAccount(userSpec1);
    UserSteps.deposit(userSpec1, account1.getId(), DepositLimits.MAX);
    UserSteps.deposit(userSpec1, account1.getId(), DepositLimits.MAX);

    CreateUserRequest user2 = AdminSteps.createUser();
    RequestSpecification userSpec2 = UserSteps.authAs(user2);
    CreateAccountResponse account2 = UserSteps.createAccount(userSpec2);

    double fundedBalance = DepositLimits.MAX * 2;
    DepositTransferRequest transferRequest = UserSteps.transferRequest(
      account1.getId(), account2.getId(), transferAmount);
    DepositTransferResponse transfer = UserSteps.transfer(userSpec1, transferRequest);

    ModelAssertions.assertThatModels(transferRequest, transfer)
      .match();

    UserSteps.assertAccountBalance(userSpec1, account1.getId(), fundedBalance - transferAmount);
    UserSteps.assertAccountBalance(userSpec2, account2.getId(), transferAmount);
  }

  static Stream<Arguments> positiveMaxTransferAmounts() {
    return Stream.of(
      Arguments.of(DepositLimits.TRANSFER_MAX),
      Arguments.of(DepositLimits.JUST_BELOW_TRANSFER_MAX));
  }

  @ParameterizedTest()
  @MethodSource("negativeTransferAmounts")
  void shouldRejectInvalidTransferAmount(double transferAmount) {
    CreateUserRequest user1 = AdminSteps.createUser();
    RequestSpecification userSpec1 = UserSteps.authAs(user1);
    CreateAccountResponse account1 = UserSteps.createAccount(userSpec1);
    UserSteps.deposit(userSpec1, account1.getId(), DepositLimits.STANDARD);

    CreateUserRequest user2 = AdminSteps.createUser();
    RequestSpecification userSpec2 = UserSteps.authAs(user2);
    CreateAccountResponse account2 = UserSteps.createAccount(userSpec2);

    UserSteps.transferExpectingBadRequest(
      userSpec1,
      UserSteps.transferRequest(account1.getId(), account2.getId(), transferAmount));

    UserSteps.assertAccountBalance(userSpec1, account1.getId(), DepositLimits.STANDARD);
    UserSteps.assertAccountBalance(userSpec2, account2.getId(), 0);
  }

  static Stream<Arguments> negativeTransferAmounts() {
    return Stream.of(
      Arguments.of(DepositLimits.ZERO),
      Arguments.of(DepositLimits.NEGATIVE));
  }

  @Test
  void shouldRejectTransferAboveMaximumLimit() {
    CreateUserRequest user1 = AdminSteps.createUser();
    RequestSpecification userSpec1 = UserSteps.authAs(user1);
    CreateAccountResponse account1 = UserSteps.createAccount(userSpec1);
    UserSteps.deposit(userSpec1, account1.getId(), DepositLimits.MAX);
    UserSteps.deposit(userSpec1, account1.getId(), DepositLimits.MAX);
    UserSteps.deposit(userSpec1, account1.getId(), DepositLimits.MAX);

    CreateUserRequest user2 = AdminSteps.createUser();
    RequestSpecification userSpec2 = UserSteps.authAs(user2);
    CreateAccountResponse account2 = UserSteps.createAccount(userSpec2);

    double fundedBalance = DepositLimits.MAX * 3;

    UserSteps.transferExpectingBadRequest(
      userSpec1,
      UserSteps.transferRequest(
        account1.getId(),
        account2.getId(),
        DepositLimits.ABOVE_TRANSFER_MAX));

    UserSteps.assertAccountBalance(userSpec1, account1.getId(), fundedBalance);
    UserSteps.assertAccountBalance(userSpec2, account2.getId(), 0);
  }
}
