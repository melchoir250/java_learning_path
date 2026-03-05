package hw_12_unit_test.task_17_valid_password;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {
    // `"Password1"` → true
    // `"pass"` → false
    // `null` → false
    // `"password"` → false

    private final PasswordValidator passwordValidator = new PasswordValidator();

    @ParameterizedTest
    @CsvSource({
            "Password1, true",
            "pass, false",
            "Password, false",
            "password, false",
    })
    public void PasswordValidator(String password, boolean expected) {
        assertEquals(expected, passwordValidator.isValidPassword(password));
    }

    @Test
    public void passwordValidatorNull() {
        assertFalse(passwordValidator.isValidPassword(null));
    }
}
