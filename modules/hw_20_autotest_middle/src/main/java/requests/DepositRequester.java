package requests;

import static io.restassured.RestAssured.given;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import models.DepositRequest;

public class DepositRequester extends Request<DepositRequest> {
  public DepositRequester(
    RequestSpecification requestSpecification,
    ResponseSpecification responseSpecification) {
    super(requestSpecification, responseSpecification);
  }

  @Override
  public ValidatableResponse post(DepositRequest model) {
    return given()
      .spec(requestSpecification)
      .body(model)
      .post("/api/v1/accounts/deposit")
      .then()
      .assertThat()
      .spec(responseSpecification);
  }
}
