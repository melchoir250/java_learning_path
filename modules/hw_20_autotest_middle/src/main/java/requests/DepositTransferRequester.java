package requests;

import static io.restassured.RestAssured.given;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import models.DepositTransferRequest;

public class DepositTransferRequester extends Request<DepositTransferRequest> {
  public DepositTransferRequester(
    RequestSpecification requestSpecification,
    ResponseSpecification responseSpecification) {
    super(requestSpecification, responseSpecification);
  }

  @Override
  public ValidatableResponse post(DepositTransferRequest model) {
    return given()
      .spec(requestSpecification)
      .body(model)
      .post("/api/v1/accounts/transfer")
      .then()
      .assertThat()
      .spec(responseSpecification);
  }
}
