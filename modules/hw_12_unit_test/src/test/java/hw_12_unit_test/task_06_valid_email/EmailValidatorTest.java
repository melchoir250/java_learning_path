package hw_12_unit_test.task_06_valid_email;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class EmailValidatorTest {
    // Корректные email: `"test@example.com"`, `"user.name@domain.co"`, `"a@b.cc"` → true
    // Некорректные email: `"bad@.com"`, `"no//at//symbol"`, `"@missing//user.com"`, `"user@domain"` → false
    // Пустая строка: `""` → false
    // `null` → false

    private final EmailValidator emailValidator = new EmailValidator();

    @ParameterizedTest
    @CsvSource({
            "test@example.com, true",
            "user.name@domain.co, true",
            "a@b.cc, true",
            "bad@.com, false",
            "no//at//symbol, false",
            "@missing//user.com, false",
            "user@domain, false",
            "'', false"
    })
    public void EmailValidator(String input, boolean except) {
        assertEquals(except, emailValidator.isValidEmail(input));
    }

    @Test
    public void nullEmailValidator() {
        assertFalse(emailValidator.isValidEmail(null));
    }
}
