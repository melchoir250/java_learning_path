package requests;

import static io.restassured.RestAssured.given;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import models.BaseModel;

public class GetProfileRequester extends Request<BaseModel> {
  public GetProfileRequester(
    RequestSpecification requestSpecification,
    ResponseSpecification responseSpecification) {
    super(requestSpecification, responseSpecification);
  }

  @Override
  public ValidatableResponse post(BaseModel model) {
    return get();
  }

  public ValidatableResponse get() {
    return given()
      .spec(requestSpecification)
      .get("/api/v1/customer/profile")
      .then()
      .assertThat()
      .spec(responseSpecification);
  }
}
