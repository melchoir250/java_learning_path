package requests;

import static io.restassured.RestAssured.given;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import models.UpdateProfileNameRequest;

public class UpdateProfileNameRequester extends Request<UpdateProfileNameRequest> {
  public UpdateProfileNameRequester(
    RequestSpecification requestSpecification,
    ResponseSpecification responseSpecification) {
    super(requestSpecification, responseSpecification);
  }

  @Override
  public ValidatableResponse post(UpdateProfileNameRequest model) {
    return put(model);
  }

  public ValidatableResponse put(UpdateProfileNameRequest model) {
    return given()
      .spec(requestSpecification)
      .body(model)
      .put("/api/v1/customer/profile")
      .then()
      .assertThat()
      .spec(responseSpecification);
  }
}
