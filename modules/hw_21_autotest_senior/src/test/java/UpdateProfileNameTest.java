import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import constants.ProfileLimits;
import io.restassured.specification.RequestSpecification;
import models.CreateUserRequest;
import requests.steps.AdminSteps;
import requests.steps.UserSteps;

@DisplayName("PUT /api/v1/customer/profile")
class UpdateProfileNameTest extends BaseTest {

  @ParameterizedTest()
  @MethodSource("positiveNames")
  void shouldAcceptValidProfileName(String newName) {
    CreateUserRequest user = AdminSteps.createUser();
    RequestSpecification userSpec = UserSteps.authAs(user);

    UserSteps.assertProfile(userSpec, user.getUsername(), null);

    UserSteps.updateProfileName(userSpec, UserSteps.updateProfileNameRequest(newName));

    UserSteps.assertProfile(userSpec, user.getUsername(), newName);
  }

  static Stream<Arguments> positiveNames() {
    return Stream.of(
      Arguments.of(ProfileLimits.VALID_FULL),
      Arguments.of(ProfileLimits.VALID_ONE_CHAR),
      Arguments.of(ProfileLimits.VALID_MAX_LENGTH));
  }

  @ParameterizedTest()
  @MethodSource("negativeNames")
  void shouldRejectInvalidProfileName(String newName) {
    CreateUserRequest user = AdminSteps.createUser();
    RequestSpecification userSpec = UserSteps.authAs(user);

    UserSteps.assertProfile(userSpec, user.getUsername(), null);

    UserSteps.updateProfileNameExpectingBadRequest(
      userSpec,
      UserSteps.updateProfileNameRequest(newName));

    UserSteps.assertProfile(userSpec, user.getUsername(), null);
  }

  static Stream<Arguments> negativeNames() {
    return Stream.of(
      Arguments.of(ProfileLimits.EMPTY),
      Arguments.of(ProfileLimits.WITH_DIGIT),
      Arguments.of(ProfileLimits.WITH_SPECIAL),
      Arguments.of(ProfileLimits.THREE_WORDS));
  }
}
