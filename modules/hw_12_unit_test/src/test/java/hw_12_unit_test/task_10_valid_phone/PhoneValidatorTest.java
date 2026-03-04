package hw_12_unit_test.task_10_valid_phone;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneValidatorTest {
    // Корректные номера: `"+1 1234567890"`, `"+44 9876543210"`, `"+999 1111111111"` → true
    // Некорректные номера: `"12345"`, `"invalid"`, `"+1 abcdefghij"`,
    // `"+1234 1234567890"`, `"+1 123"`, `""` → false
    // `null` → исключение

    private final PhoneValidator phoneValidator = new PhoneValidator();

    @ParameterizedTest
    @CsvSource({
            "'+1 1234567890', true",
            "'+44 9876543210', true",
            "'+999 1111111111', true",
    })
    public void correctNumberPhoneValidator(String phone, boolean expect) {
        assertEquals(expect, phoneValidator.isValidPhoneNumber(phone));
    }

    @ParameterizedTest
    @CsvSource({
            "'12345', false",
            "'invalid', false",
            "'+1 abcdefghij', false",
            "'+1234 1234567890', false",
            "'+1 123', false",
            "'', false"
    })
    public void inCorrectNumberPhoneValidator(String phone, boolean expect) {
        assertEquals(expect, phoneValidator.isValidPhoneNumber(phone));
    }

    @Test
    public void nullPhoneValidator() {
        assertThrows(NullPointerException.class, () -> {
            phoneValidator.isValidPhoneNumber(null);
        });
    }
}
