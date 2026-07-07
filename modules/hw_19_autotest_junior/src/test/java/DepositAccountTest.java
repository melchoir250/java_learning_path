import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@DisplayName("POST /api/v1/accounts/deposit")
class DepositAccountTest {
    @BeforeAll
    public static void setupRestAssured() {
        RestAssured.filters(
                List.of(new RequestLoggingFilter(),
                        new ResponseLoggingFilter()));
    }

    String baseUrl = "http://localhost:4111";
    String username = "Ivan" + ThreadLocalRandom.current().nextInt(100, 900);
    String password = username + "IVAN!";
    String role = "USER";
    String adminAuthorizationToken = "Basic YWRtaW46YWRtaW4=";

    @Test
    public void shouldDepositMoneyToExistingAccount() {
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", adminAuthorizationToken)
                .body("""
                        {
                          "username": "%s",
                          "password": "%s",
                          "role": "%s"
                        }
                        """.formatted(username, password, role))
                .post(baseUrl + "/api/v1/admin/users")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_CREATED);

        String userAuth = login(username, password);

        int accountId = given()
                .header("Authorization", userAuth)
                .post(baseUrl + "/api/v1/accounts")
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .extract()
                .path("id");

        given()
                .contentType(ContentType.JSON)
                .header("Authorization", userAuth)
                .body("""
                        {
                            "id": %d,
                            "balance": 1000
                        }
                        """.formatted(accountId))
                .post(baseUrl + "/api/v1/accounts/deposit")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("id", equalTo(accountId))
                .body("balance", equalTo(1000.0f))
                .body("transactions[0].amount", equalTo(1000.0f))
                .body("transactions[0].type", equalTo("DEPOSIT"));
    }

    @Test
    public void shouldReturnUpdatedBalanceAfterDeposit() {
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", adminAuthorizationToken)
                .body("""
                        {
                          "username": "%s",
                          "password": "%s",
                          "role": "%s"
                        }
                        """.formatted(username, password, role))
                .post(baseUrl + "/api/v1/admin/users")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_CREATED);

        String userAuth = login(username, password);

        int accountId = given()
                .header("Authorization", userAuth)
                .post(baseUrl + "/api/v1/accounts")
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .extract()
                .path("id");

        given()
                .contentType(ContentType.JSON)
                .header("Authorization", userAuth)
                .body("""
                        {
                            "id": %d,
                            "balance": 1000
                        }
                        """.formatted(accountId))
                .post(baseUrl + "/api/v1/accounts/deposit")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("id", equalTo(accountId))
                .body("balance", equalTo(1000.0f))
                .body("transactions[0].amount", equalTo(1000.0f))
                .body("transactions[0].type", equalTo("DEPOSIT"));

        given()
                .header("Authorization", userAuth)
                .get(baseUrl + "/api/v1/customer/accounts")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("find { it.id == " + accountId + " }.balance", equalTo(1000.0f));

    }

    @Test
    public void shouldDepositAmountWithCents() {

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", adminAuthorizationToken)
                .body("""
                        {
                          "username": "%s",
                          "password": "%s",
                          "role": "%s"
                        }
                        """.formatted(username, password, role))
                .post(baseUrl + "/api/v1/admin/users")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_CREATED);

        String userAuth = login(username, password);

        int accountId = given()
                .header("Authorization", userAuth)
                .post(baseUrl + "/api/v1/accounts")
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .extract()
                .path("id");

        given()
                .contentType(ContentType.JSON)
                .header("Authorization", userAuth)
                .body("""
                        {
                            "id": %d,
                            "balance": 100.5
                        }
                        """.formatted(accountId))
                .post(baseUrl + "/api/v1/accounts/deposit")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("id", equalTo(accountId))
                .body("balance", equalTo(100.5f))
                .body("transactions[0].amount", equalTo(100.5f))
                .body("transactions[0].type", equalTo("DEPOSIT"));
    }

    @Test
    public void shouldDepositMaximumAllowedAmount() {

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", adminAuthorizationToken)
                .body("""
                        {
                          "username": "%s",
                          "password": "%s",
                          "role": "%s"
                        }
                        """.formatted(username, password, role))
                .post(baseUrl + "/api/v1/admin/users")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_CREATED);

        String userAuth = login(username, password);

        int accountId = given()
                .header("Authorization", userAuth)
                .post(baseUrl + "/api/v1/accounts")
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .extract()
                .path("id");

        given()
                .contentType(ContentType.JSON)
                .header("Authorization", userAuth)
                .body("""
                        {
                            "id": %d,
                            "balance": 5000
                        }
                        """.formatted(accountId))
                .post(baseUrl + "/api/v1/accounts/deposit")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("id", equalTo(accountId))
                .body("balance", equalTo(5000f))
                .body("transactions[0].amount", equalTo(5000f))
                .body("transactions[0].type", equalTo("DEPOSIT"));
    }

    @Test
    public void shouldDepositAmountJustBelowMaximumLimit() {

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", adminAuthorizationToken)
                .body("""
                        {
                          "username": "%s",
                          "password": "%s",
                          "role": "%s"
                        }
                        """.formatted(username, password, role))
                .post(baseUrl + "/api/v1/admin/users")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_CREATED);

        String userAuth = login(username, password);

        int accountId = given()
                .header("Authorization", userAuth)
                .post(baseUrl + "/api/v1/accounts")
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .extract()
                .path("id");

        given()
                .contentType(ContentType.JSON)
                .header("Authorization", userAuth)
                .body("""
                        {
                            "id": %d,
                            "balance": 4999.99
                        }
                        """.formatted(accountId))
                .post(baseUrl + "/api/v1/accounts/deposit")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("id", equalTo(accountId))
                .body("balance", equalTo(4999.99f))
                .body("transactions[0].amount", equalTo(4999.99f))
                .body("transactions[0].type", equalTo("DEPOSIT"));
    }

    @Test
    public void shouldRejectDepositWithNegativeAmount() {

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", adminAuthorizationToken)
                .body("""
                        {
                          "username": "%s",
                          "password": "%s",
                          "role": "%s"
                        }
                        """.formatted(username, password, role))
                .post(baseUrl + "/api/v1/admin/users")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_CREATED);

        String userAuth = login(username, password);

        int accountId = given()
                .header("Authorization", userAuth)
                .post(baseUrl + "/api/v1/accounts")
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .extract()
                .path("id");

        given()
                .contentType(ContentType.JSON)
                .header("Authorization", userAuth)
                .body("""
                        {
                            "id": %d,
                            "balance": -10
                        }
                        """.formatted(accountId))
                .post(baseUrl + "/api/v1/accounts/deposit")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body(equalTo("Deposit amount must be at least 0.01"));
    }

    @Test
    public void shouldRejectDepositWithZeroAmount() {

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", adminAuthorizationToken)
                .body("""
                        {
                          "username": "%s",
                          "password": "%s",
                          "role": "%s"
                        }
                        """.formatted(username, password, role))
                .post(baseUrl + "/api/v1/admin/users")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_CREATED);

        String userAuth = login(username, password);

        int accountId = given()
                .header("Authorization", userAuth)
                .post(baseUrl + "/api/v1/accounts")
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .extract()
                .path("id");

        given()
                .contentType(ContentType.JSON)
                .header("Authorization", userAuth)
                .body("""
                        {
                            "id": %d,
                            "balance": 0
                        }
                        """.formatted(accountId))
                .post(baseUrl + "/api/v1/accounts/deposit")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body(equalTo("Deposit amount must be at least 0.01"));
    }

    @Test
    public void shouldRejectDepositAboveMaximumLimit() {

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", adminAuthorizationToken)
                .body("""
                        {
                          "username": "%s",
                          "password": "%s",
                          "role": "%s"
                        }
                        """.formatted(username, password, role))
                .post(baseUrl + "/api/v1/admin/users")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_CREATED);

        String userAuth = login(username, password);

        int accountId = given()
                .header("Authorization", userAuth)
                .post(baseUrl + "/api/v1/accounts")
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .extract()
                .path("id");

        given()
                .contentType(ContentType.JSON)
                .header("Authorization", userAuth)
                .body("""
                        {
                            "id": %d,
                            "balance": 5001
                        }
                        """.formatted(accountId))
                .post(baseUrl + "/api/v1/accounts/deposit")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body(equalTo("Deposit amount cannot exceed 5000"));

    }

    @Test
    public void shouldRejectDepositToNonExistingAccount() {
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", adminAuthorizationToken)
                .body("""
                        {
                          "username": "%s",
                          "password": "%s",
                          "role": "%s"
                        }
                        """.formatted(username, password, role))
                .post(baseUrl + "/api/v1/admin/users")
                .then()
                .statusCode(HttpStatus.SC_CREATED);

        String userAuth = login(username, password);

        int nonExistingAccountId = 100;

        given()
                .contentType(ContentType.JSON)
                .header("Authorization", userAuth)
                .body("""
                        {
                            "id": %d,
                            "balance": 100
                        }
                        """.formatted(nonExistingAccountId))
                .post(baseUrl + "/api/v1/accounts/deposit")
                .then()
                .statusCode(HttpStatus.SC_FORBIDDEN)
                .body(equalTo("Unauthorized access to account"));
    }

    @Test
    public void shouldRejectDepositWithoutAuthorization() {
        given()
                .contentType(ContentType.JSON)
                .body("""
                        {
                            "id": 1,
                            "balance": 100
                        }
                        """)
                .post(baseUrl + "/api/v1/accounts/deposit")
                .then()
                .statusCode(HttpStatus.SC_UNAUTHORIZED);
    }

    private String login(String username, String password) {
        return given()
                .contentType(ContentType.JSON)
                .body("""
                        {
                        "username": "%s",
                        "password": "%s"
                        }
                        """.formatted(username, password))
                .post(baseUrl + "/api/v1/auth/login")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .header("Authorization");
    }
}