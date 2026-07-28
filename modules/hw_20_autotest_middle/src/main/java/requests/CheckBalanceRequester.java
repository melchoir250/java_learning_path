package requests;

import static io.restassured.RestAssured.given;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import models.BaseModel;

public class CheckBalanceRequester extends Request<BaseModel> {
  public CheckBalanceRequester(
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
      .get("/api/v1/customer/accounts")
      .then()
      .assertThat()
      .spec(responseSpecification);
  }
}
