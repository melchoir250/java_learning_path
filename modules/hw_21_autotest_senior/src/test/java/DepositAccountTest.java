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
import models.DepositRequest;
import models.DepositResponse;
import models.comparison.ModelAssertions;
import requests.steps.AdminSteps;
import requests.steps.UserSteps;

@DisplayName("POST /api/v1/accounts/deposit")
class DepositAccountTest extends BaseTest {

  @ParameterizedTest()
  @MethodSource("positiveDepositAmounts")
  void shouldAcceptPositiveDepositAmount(double depositAmount) {
    CreateUserRequest user = AdminSteps.createUser();
    RequestSpecification userSpec = UserSteps.authAs(user);
    CreateAccountResponse account = UserSteps.createAccount(userSpec);
    DepositRequest depositRequest = UserSteps.depositRequest(account.getId(), depositAmount);
    DepositResponse deposit = UserSteps.deposit(userSpec, depositRequest);
    ModelAssertions.assertThatModels(depositRequest, deposit)
      .match();
    UserSteps.assertAccountBalance(userSpec, account.getId(), depositAmount);
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
    CreateUserRequest user = AdminSteps.createUser();
    RequestSpecification userSpec = UserSteps.authAs(user);
    CreateAccountResponse account = UserSteps.createAccount(userSpec);
    UserSteps.depositExpectingBadRequest(
      userSpec,
      UserSteps.depositRequest(account.getId(), depositAmount),
      expectedError);
    UserSteps.assertAccountBalance(userSpec, account.getId(), 0);
  }

  static Stream<Arguments> negativeDepositAmounts() {
    return Stream.of(
      Arguments.of(DepositLimits.NEGATIVE, DepositLimits.MIN_AMOUNT_ERROR),
      Arguments.of(DepositLimits.ZERO, DepositLimits.MIN_AMOUNT_ERROR),
      Arguments.of(DepositLimits.ABOVE_MAX, DepositLimits.MAX_AMOUNT_ERROR));
  }

  @Test
  void shouldRejectDepositToNonExistingAccount() {
    CreateUserRequest user = AdminSteps.createUser();
    RequestSpecification userSpec = UserSteps.authAs(user);
    CreateAccountResponse account = UserSteps.createAccount(userSpec);
    UserSteps.depositExpectingForbidden(
      userSpec,
      UserSteps.depositRequest(
        DepositLimits.NON_EXISTING_ACCOUNT_ID,
        DepositLimits.STANDARD),
      DepositLimits.UNAUTHORIZED_ACCOUNT_ERROR);
    UserSteps.assertAccountBalance(userSpec, account.getId(), 0);
  }

  @Test
  void shouldRejectDepositWithoutAuthorization() {
    UserSteps.depositExpectingUnauthorized(
      UserSteps.depositRequest(
        DepositLimits.UNAUTHORIZED_TEST_ACCOUNT_ID,
        DepositLimits.STANDARD));
  }
}
