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

@DisplayName("PUT /api/v1/customer/profile")
public class UpdateProfileNameTest {
    @BeforeAll
    public static void setupRestAssured() {
        RestAssured.filters(
                List.of(new RequestLoggingFilter(),
                        new ResponseLoggingFilter()));
    }

    String baseUrl = "http://localhost:4111";
    String username = "Max" + ThreadLocalRandom.current().nextInt(1, 10000);
    String password = username + "MAX!";
    String role = "USER";
    String adminAuthorizationToken = "Basic YWRtaW46YWRtaW4=";

    @Test
    public void profile_shouldSucceed_forValidFullName() {
        createUser(username, password, role);
        String userAuth = login(username, password);
        String newName = "MAXIMUS Petrov";

        getProfile(userAuth, username, null);

        given()
                .contentType(ContentType.JSON)
                .header("Authorization", userAuth)
                .body("""
                        {
                        "name": "%s"
                        }
                        """.formatted(newName))
                .put(baseUrl + "/api/v1/customer/profile")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("message", equalTo("Profile updated successfully"))
                .body("customer.name", equalTo(newName));

        getProfile(userAuth, username, newName);
    }

    @Test
    public void profile_shouldSucceed_forOneCharacterPerWord() {
        createUser(username, password, role);
        String userAuth = login(username, password);
        String newName = "M P";

        getProfile(userAuth, username, null);

        given()
                .contentType(ContentType.JSON)
                .header("Authorization", userAuth)
                .body("""
                        {
                        "name": "%s"
                        }
                        """.formatted(newName))
                .put(baseUrl + "/api/v1/customer/profile")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("message", equalTo("Profile updated successfully"))
                .body("customer.name", equalTo(newName));

        getProfile(userAuth, username, newName);
    }

    @Test
    public void profile_shouldSucceed_forMaximumAllowedLength() {
        createUser(username, password, role);
        String userAuth = login(username, password);
        String newName = "A".repeat(100) + " " + "B".repeat(99);

        getProfile(userAuth, username, null);

        given()
                .contentType(ContentType.JSON)
                .header("Authorization", userAuth)
                .body("""
                        {
                        "name": "%s"
                        }
                        """.formatted(newName))
                .put(baseUrl + "/api/v1/customer/profile")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("message", equalTo("Profile updated successfully"))
                .body("customer.name", equalTo(newName));

        getProfile(userAuth, username, newName);
    }

    @Test
    public void profile_shouldFail_forEmptyName() {
        createUser(username, password, role);
        String userAuth = login(username, password);
        String newName = " ";

        getProfile(userAuth, username, null);

        given()
                .contentType(ContentType.JSON)
                .header("Authorization", userAuth)
                .body("""
                        {
                        "name": "%s"
                        }
                        """.formatted(newName))
                .put(baseUrl + "/api/v1/customer/profile")
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    @Test
    public void profile_shouldFail_forDigitInName() {
        createUser(username, password, role);
        String userAuth = login(username, password);
        String newName = "Petrov123";

        getProfile(userAuth, username, null);

        given()
                .contentType(ContentType.JSON)
                .header("Authorization", userAuth)
                .body("""
                        {
                        "name": "%s"
                        }
                        """.formatted(newName))
                .put(baseUrl + "/api/v1/customer/profile")
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    @Test
    public void profile_shouldFail_forSpecialCharacterInName() {
        createUser(username, password, role);
        String userAuth = login(username, password);
        String newName = "Petrov@";

        getProfile(userAuth, username, null);

        given()
                .contentType(ContentType.JSON)
                .header("Authorization", userAuth)
                .body("""
                        {
                        "name": "%s"
                        }
                        """.formatted(newName))
                .put(baseUrl + "/api/v1/customer/profile")
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    @Test
    public void profile_shouldFail_forNameAboveMaximumLength() {
        createUser(username, password, role);
        String userAuth = login(username, password);
        String newName = "A".repeat(500) + " " + "B".repeat(205);

        getProfile(userAuth, username, null);

        given()
                .contentType(ContentType.JSON)
                .header("Authorization", userAuth)
                .body("""
                        {
                        "name": "%s"
                        }
                        """.formatted(newName))
                .put(baseUrl + "/api/v1/customer/profile")
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    @Test
    public void profile_shouldFail_forThreeWords() {
        createUser(username, password, role);
        String userAuth = login(username, password);
        String newName = "A B C";

        getProfile(userAuth, username, null);

        given()
                .contentType(ContentType.JSON)
                .header("Authorization", userAuth)
                .body("""
                        {
                        "name": "%s"
                        }
                        """.formatted(newName))
                .put(baseUrl + "/api/v1/customer/profile")
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
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

    private void getProfile(String userAuth, String expectedUsername, String expectedName) {
        given()
                .header("Authorization", userAuth)
                .get(baseUrl + "/api/v1/customer/profile")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("username", equalTo(expectedUsername))
                .body("name", equalTo(expectedName));
    }
}
