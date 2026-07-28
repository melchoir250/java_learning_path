import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import constants.ProfileLimits;
import generators.RandomData;
import io.restassured.specification.RequestSpecification;
import models.CreateUserRequest;
import models.CustomerProfile;
import models.UpdateProfileNameRequest;
import models.UpdateProfileNameResponse;
import models.UserRole;
import requests.AdminCreateUserRequester;
import requests.GetProfileRequester;
import requests.UpdateProfileNameRequester;
import specs.RequestSpecs;
import specs.ResponseSpecs;

@DisplayName("PUT /api/v1/customer/profile")
class UpdateProfileNameTest extends BaseTest {

  @ParameterizedTest()
  @MethodSource("positiveNames")
  void shouldAcceptValidProfileName(String newName) {
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

    CustomerProfile profileBefore = new GetProfileRequester(
      userSpec,
      ResponseSpecs.requestReturnsOK())
        .get()
        .extract()
        .as(CustomerProfile.class);

    softly.assertThat(profileBefore.getUsername())
      .isEqualTo(userRequest.getUsername());
    softly.assertThat(profileBefore.getName())
      .isNull();

    UpdateProfileNameResponse update = new UpdateProfileNameRequester(
      userSpec,
      ResponseSpecs.requestReturnsOK())
        .put(UpdateProfileNameRequest.builder()
          .name(newName)
          .build())
        .extract()
        .as(UpdateProfileNameResponse.class);

    softly.assertThat(update.getMessage())
      .isEqualTo(ProfileLimits.SUCCESS_MESSAGE);
    softly.assertThat(update.getCustomer()
      .getName())
      .isEqualTo(newName);

    CustomerProfile profileAfter = new GetProfileRequester(
      userSpec,
      ResponseSpecs.requestReturnsOK())
        .get()
        .extract()
        .as(CustomerProfile.class);

    softly.assertThat(profileAfter.getUsername())
      .isEqualTo(userRequest.getUsername());
    softly.assertThat(profileAfter.getName())
      .isEqualTo(newName);
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

    new GetProfileRequester(
      userSpec,
      ResponseSpecs.requestReturnsOK())
        .get();

    new UpdateProfileNameRequester(
      userSpec,
      ResponseSpecs.requestReturnsBadRequest())
        .put(UpdateProfileNameRequest.builder()
          .name(newName)
          .build());
  }

  static Stream<Arguments> negativeNames() {
    return Stream.of(
      Arguments.of(ProfileLimits.EMPTY),
      Arguments.of(ProfileLimits.WITH_DIGIT),
      Arguments.of(ProfileLimits.WITH_SPECIAL),
      Arguments.of(ProfileLimits.THREE_WORDS));
  }
}
