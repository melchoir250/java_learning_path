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

@DisplayName("POST /api/v1/accounts/transfer")
public class TransferMoneyTest {
    @BeforeAll
    public static void setupRestAssured() {
        RestAssured.filters(
                List.of(new RequestLoggingFilter(),
                        new ResponseLoggingFilter()));
    }

    String baseUrl = "http://localhost:4111";
    String username_1 = "Vasya" + ThreadLocalRandom.current().nextInt(1, 10000);
    String password_1 = username_1 + "VASYA%";
    String username_2 = "Petya" + ThreadLocalRandom.current().nextInt(1, 10000);
    String password_2 = username_2 + "PETA%";
    String role = "USER";
    String adminAuthorizationToken = "Basic YWRtaW46YWRtaW4=";

    @Test
    public void transfer_shouldSucceed_forValidAmount() {
        createUser(username_1, password_1, role);

        String userAuth_1 = login(username_1, password_1);

        int accountId_1 = createAccount(userAuth_1);

        given()
                .contentType(ContentType.JSON)
                .header("Authorization", userAuth_1)
                .body("""
                        {
                            "id": %d,
                            "balance": 1000
                        }
                        """.formatted(accountId_1))
                .post(baseUrl + "/api/v1/accounts/deposit")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("id", equalTo(accountId_1))
                .body("balance", equalTo(1000.0f))
                .body("transactions[0].amount", equalTo(1000.0f))
                .body("transactions[0].type", equalTo("DEPOSIT"));

        createUser(username_2, password_2, role);

        String userAuth_2 = login(username_2, password_2);

        int accountId_2 = createAccount(userAuth_2);

        given()
                .contentType(ContentType.JSON)
                .header("Authorization", userAuth_1)
                .body("""
                        {
                          "senderAccountId": %d,
                          "receiverAccountId": %d,
                          "amount": 50
                        }
                        """.formatted(accountId_1, accountId_2))
                .post(baseUrl + "/api/v1/accounts/transfer")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("senderAccountId", equalTo(accountId_1))
                .body("receiverAccountId", equalTo(accountId_2))
                .body("amount", equalTo(50.0f))
                .body("message", equalTo("Transfer successful"));

        given()
                .header("Authorization", userAuth_1)
                .get(baseUrl + "/api/v1/customer/accounts")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("find { it.id == " + accountId_1 + " }.balance", equalTo(950.0f));

        given()
                .header("Authorization", userAuth_2)
                .get(baseUrl + "/api/v1/customer/accounts")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("find { it.id == " + accountId_2 + " }.balance", equalTo(50.0f));
    }

    @Test
    public void transfer_shouldSucceed_forMinimumAllowedAmount() {
        createUser(username_1, password_1, role);

        String userAuth_1 = login(username_1, password_1);

        int accountId_1 = createAccount(userAuth_1);

        given()
                .contentType(ContentType.JSON)
                .header("Authorization", userAuth_1)
                .body("""
                        {
                            "id": %d,
                            "balance": 1000
                        }
                        """.formatted(accountId_1))
                .post(baseUrl + "/api/v1/accounts/deposit")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("id", equalTo(accountId_1))
                .body("balance", equalTo(1000.0f))
                .body("transactions[0].amount", equalTo(1000.0f))
                .body("transactions[0].type", equalTo("DEPOSIT"));

        createUser(username_2, password_2, role);

        String userAuth_2 = login(username_2, password_2);

        int accountId_2 = createAccount(userAuth_2);

        given()
                .contentType(ContentType.JSON)
                .header("Authorization", userAuth_1)
                .body("""
                        {
                          "senderAccountId": %d,
                          "receiverAccountId": %d,
                          "amount": 0.01
                        }
                        """.formatted(accountId_1, accountId_2))
                .post(baseUrl + "/api/v1/accounts/transfer")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("senderAccountId", equalTo(accountId_1))
                .body("receiverAccountId", equalTo(accountId_2))
                .body("amount", equalTo(0.01f))
                .body("message", equalTo("Transfer successful"));

        given()
                .header("Authorization", userAuth_1)
                .get(baseUrl + "/api/v1/customer/accounts")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("find { it.id == " + accountId_1 + " }.balance", equalTo(999.99f));

        given()
                .header("Authorization", userAuth_2)
                .get(baseUrl + "/api/v1/customer/accounts")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("find { it.id == " + accountId_2 + " }.balance", equalTo(0.01f));
    }

    @Test
    public void transfer_shouldSucceed_forMaximumAllowedAmount() {
        createUser(username_1, password_1, role);

        String userAuth_1 = login(username_1, password_1);

        int accountId_1 = createAccount(userAuth_1);

        given()
                .contentType(ContentType.JSON)
                .header("Authorization", userAuth_1)
                .body("""
                        {
                            "id": %d,
                            "balance": 5000
                        }
                        """.formatted(accountId_1))
                .post(baseUrl + "/api/v1/accounts/deposit")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("id", equalTo(accountId_1))
                .body("balance", equalTo(5000.0f))
                .body("transactions[0].amount", equalTo(5000.0f))
                .body("transactions[0].type", equalTo("DEPOSIT"));
        given()
                .contentType(ContentType.JSON)
                .header("Authorization", userAuth_1)
                .body("""
                        {
                            "id": %d,
                            "balance": 5000
                        }
                        """.formatted(accountId_1))
                .post(baseUrl + "/api/v1/accounts/deposit")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("id", equalTo(accountId_1))
                .body("balance", equalTo(10000.0f))
                .body("transactions[0].amount", equalTo(5000.0f))
                .body("transactions[0].type", equalTo("DEPOSIT"));

        createUser(username_2, password_2, role);

        String userAuth_2 = login(username_2, password_2);

        int accountId_2 = createAccount(userAuth_2);

        given()
                .contentType(ContentType.JSON)
                .header("Authorization", userAuth_1)
                .body("""
                        {
                          "senderAccountId": %d,
                          "receiverAccountId": %d,
                          "amount": 10000
                        }
                        """.formatted(accountId_1, accountId_2))
                .post(baseUrl + "/api/v1/accounts/transfer")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("senderAccountId", equalTo(accountId_1))
                .body("receiverAccountId", equalTo(accountId_2))
                .body("amount", equalTo(10000.0f))
                .body("message", equalTo("Transfer successful"));

        given()
                .header("Authorization", userAuth_1)
                .get(baseUrl + "/api/v1/customer/accounts")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("find { it.id == " + accountId_1 + " }.balance", equalTo(0.0f));

        given()
                .header("Authorization", userAuth_2)
                .get(baseUrl + "/api/v1/customer/accounts")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("find { it.id == " + accountId_2 + " }.balance", equalTo(10000.0f));
    }

    @Test
    public void transfer_shouldSucceed_forAmountBelowMaximumLimit() {
        createUser(username_1, password_1, role);

        String userAuth_1 = login(username_1, password_1);

        int accountId_1 = createAccount(userAuth_1);

        given()
                .contentType(ContentType.JSON)
                .header("Authorization", userAuth_1)
                .body("""
                        {
                            "id": %d,
                            "balance": 5000
                        }
                        """.formatted(accountId_1))
                .post(baseUrl + "/api/v1/accounts/deposit")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("id", equalTo(accountId_1))
                .body("balance", equalTo(5000.0f))
                .body("transactions[0].amount", equalTo(5000.0f))
                .body("transactions[0].type", equalTo("DEPOSIT"));
        given()
                .contentType(ContentType.JSON)
                .header("Authorization", userAuth_1)
                .body("""
                        {
                            "id": %d,
                            "balance": 5000
                        }
                        """.formatted(accountId_1))
                .post(baseUrl + "/api/v1/accounts/deposit")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("id", equalTo(accountId_1))
                .body("balance", equalTo(10000.0f))
                .body("transactions[0].amount", equalTo(5000.0f))
                .body("transactions[0].type", equalTo("DEPOSIT"));

        createUser(username_2, password_2, role);

        String userAuth_2 = login(username_2, password_2);

        int accountId_2 = createAccount(userAuth_2);

        given()
                .contentType(ContentType.JSON)
                .header("Authorization", userAuth_1)
                .body("""
                        {
                          "senderAccountId": %d,
                          "receiverAccountId": %d,
                          "amount": 9999.99
                        }
                        """.formatted(accountId_1, accountId_2))
                .post(baseUrl + "/api/v1/accounts/transfer")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("senderAccountId", equalTo(accountId_1))
                .body("receiverAccountId", equalTo(accountId_2))
                .body("amount", equalTo(9999.99f))
                .body("message", equalTo("Transfer successful"));

        given()
                .header("Authorization", userAuth_1)
                .get(baseUrl + "/api/v1/customer/accounts")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("find { it.id == " + accountId_1 + " }.balance", equalTo(0.01f));

        given()
                .header("Authorization", userAuth_2)
                .get(baseUrl + "/api/v1/customer/accounts")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("find { it.id == " + accountId_2 + " }.balance", equalTo(9999.99f));
    }

    @Test
    public void transfer_shouldFail_forZeroAmount() {
        createUser(username_1, password_1, role);

        String userAuth_1 = login(username_1, password_1);

        int accountId_1 = createAccount(userAuth_1);

        given()
                .contentType(ContentType.JSON)
                .header("Authorization", userAuth_1)
                .body("""
                        {
                            "id": %d,
                            "balance": 1000
                        }
                        """.formatted(accountId_1))
                .post(baseUrl + "/api/v1/accounts/deposit")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("id", equalTo(accountId_1))
                .body("balance", equalTo(1000.0f))
                .body("transactions[0].amount", equalTo(1000.0f))
                .body("transactions[0].type", equalTo("DEPOSIT"));

        createUser(username_2, password_2, role);

        String userAuth_2 = login(username_2, password_2);

        int accountId_2 = createAccount(userAuth_2);

        given()
                .contentType(ContentType.JSON)
                .header("Authorization", userAuth_1)
                .body("""
                        {
                          "senderAccountId": %d,
                          "receiverAccountId": %d,
                          "amount": 0
                        }
                        """.formatted(accountId_1, accountId_2))
                .post(baseUrl + "/api/v1/accounts/transfer")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_BAD_REQUEST);

        given()
                .header("Authorization", userAuth_1)
                .get(baseUrl + "/api/v1/customer/accounts")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("find { it.id == " + accountId_1 + " }.balance", equalTo(1000.0f));

        given()
                .header("Authorization", userAuth_2)
                .get(baseUrl + "/api/v1/customer/accounts")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("find { it.id == " + accountId_2 + " }.balance", equalTo(0.0f));
    }

    @Test
    public void transfer_shouldFail_forNegativeAmount() {
        createUser(username_1, password_1, role);

        String userAuth_1 = login(username_1, password_1);

        int accountId_1 = createAccount(userAuth_1);

        given()
                .contentType(ContentType.JSON)
                .header("Authorization", userAuth_1)
                .body("""
                        {
                            "id": %d,
                            "balance": 1000
                        }
                        """.formatted(accountId_1))
                .post(baseUrl + "/api/v1/accounts/deposit")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("id", equalTo(accountId_1))
                .body("balance", equalTo(1000.0f))
                .body("transactions[0].amount", equalTo(1000.0f))
                .body("transactions[0].type", equalTo("DEPOSIT"));

        createUser(username_2, password_2, role);

        String userAuth_2 = login(username_2, password_2);

        int accountId_2 = createAccount(userAuth_2);

        given()
                .contentType(ContentType.JSON)
                .header("Authorization", userAuth_1)
                .body("""
                        {
                          "senderAccountId": %d,
                          "receiverAccountId": %d,
                          "amount": -10
                        }
                        """.formatted(accountId_1, accountId_2))
                .post(baseUrl + "/api/v1/accounts/transfer")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_BAD_REQUEST);

        given()
                .header("Authorization", userAuth_1)
                .get(baseUrl + "/api/v1/customer/accounts")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("find { it.id == " + accountId_1 + " }.balance", equalTo(1000.0f));

        given()
                .header("Authorization", userAuth_2)
                .get(baseUrl + "/api/v1/customer/accounts")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("find { it.id == " + accountId_2 + " }.balance", equalTo(0.0f));
    }

    @Test
    public void transfer_shouldFail_forAmountAboveMaximumLimit() {
        createUser(username_1, password_1, role);

        String userAuth_1 = login(username_1, password_1);

        int accountId_1 = createAccount(userAuth_1);

        given()
                .contentType(ContentType.JSON)
                .header("Authorization", userAuth_1)
                .body("""
                        {
                            "id": %d,
                            "balance": 5000
                        }
                        """.formatted(accountId_1))
                .post(baseUrl + "/api/v1/accounts/deposit")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("id", equalTo(accountId_1))
                .body("balance", equalTo(5000.0f))
                .body("transactions[0].amount", equalTo(5000.0f))
                .body("transactions[0].type", equalTo("DEPOSIT"));
        given()
                .contentType(ContentType.JSON)
                .header("Authorization", userAuth_1)
                .body("""
                        {
                            "id": %d,
                            "balance": 5000
                        }
                        """.formatted(accountId_1))
                .post(baseUrl + "/api/v1/accounts/deposit")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("id", equalTo(accountId_1))
                .body("balance", equalTo(10000.0f))
                .body("transactions[0].amount", equalTo(5000.0f))
                .body("transactions[0].type", equalTo("DEPOSIT"));

        given()
                .contentType(ContentType.JSON)
                .header("Authorization", userAuth_1)
                .body("""
                        {
                            "id": %d,
                            "balance": 5000
                        }
                        """.formatted(accountId_1))
                .post(baseUrl + "/api/v1/accounts/deposit")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("id", equalTo(accountId_1))
                .body("balance", equalTo(15000.0f))
                .body("transactions[0].amount", equalTo(5000.0f))
                .body("transactions[0].type", equalTo("DEPOSIT"));

        createUser(username_2, password_2, role);

        String userAuth_2 = login(username_2, password_2);

        int accountId_2 = createAccount(userAuth_2);

        given()
                .contentType(ContentType.JSON)
                .header("Authorization", userAuth_1)
                .body("""
                        {
                          "senderAccountId": %d,
                          "receiverAccountId": %d,
                          "amount": 10001
                        }
                        """.formatted(accountId_1, accountId_2))
                .post(baseUrl + "/api/v1/accounts/transfer")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_BAD_REQUEST);

        given()
                .header("Authorization", userAuth_1)
                .get(baseUrl + "/api/v1/customer/accounts")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("find { it.id == " + accountId_1 + " }.balance", equalTo(15000.0f));

        given()
                .header("Authorization", userAuth_2)
                .get(baseUrl + "/api/v1/customer/accounts")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("find { it.id == " + accountId_2 + " }.balance", equalTo(0.0f));
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

    private void createUser(String username, String password, String role) {
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
    }

    private int createAccount(String userAuth) {
        return given()
                .header("Authorization", userAuth)
                .post(baseUrl + "/api/v1/accounts")
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .extract()
                .path("id");
    }
}
