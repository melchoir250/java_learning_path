package task_02_user_validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserValidatorTest {
    private UserValidator validator;

    @BeforeEach
    void setUp() {
        validator = new UserValidator();
        UserValidator.setValidationEnabled(true);
    }

    @Test
    void shouldValidateCorrectUser() {
        User user = new User(22, "Petr", "petr_vasilevich@gmail.com");

        assertDoesNotThrow(() -> validator.validate(user));
    }

    @Test
    void shouldThrowExceptionWhenUserIsNull() {
        InvalidUserException exception = assertThrows(InvalidUserException.class,
                () -> validator.validate(null));

        assertEquals("Пользователь не должен быть null", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenNameIsNull() {
        User user = new User(22, null, "petr_vasilevich@gmail.com");

        InvalidUserException exception = assertThrows(InvalidUserException.class,
                () -> validator.validate(user));

        assertEquals("Имя не должно быть пустым", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenNameIsEmpty() {
        User user = new User(22, "", "petr_vasilevich@gmail.com");

        InvalidUserException exception = assertThrows(InvalidUserException.class,
                () -> validator.validate(user));

        assertEquals("Имя не должно быть пустым", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenNameStartsWithLowercase() {
        User user = new User(22, "petr", "petr_vasilevich@gmail.com");

        InvalidUserException exception = assertThrows(InvalidUserException.class,
                () -> validator.validate(user));

        assertEquals("Имя должно начинаться с заглавной буквы", exception.getMessage());
    }

    @Test
    void shouldAcceptAge18() {
        User user = new User(18, "Petr", "petr_vasilevich@gmail.com");

        assertDoesNotThrow(() -> validator.validate(user));
    }

    @Test
    void shouldAcceptAge100() {
        User user = new User(100, "Petr", "petr_vasilevich@gmail.com");

        assertDoesNotThrow(() -> validator.validate(user));
    }

    @Test
    void shouldThrowExceptionWhenAgeLessThan18() {
        User user = new User(16, "Petr", "petr_vasilevich@gmail.com");

        InvalidUserException exception = assertThrows(InvalidUserException.class,
                () -> validator.validate(user));

        assertEquals("Возраст должен быть в диапазоне от 18 до 100 лет", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenAgeMoreThan100() {
        User user = new User(101, "Petr", "petr_vasilevich@gmail.com");

        InvalidUserException exception = assertThrows(InvalidUserException.class,
                () -> validator.validate(user));

        assertEquals("Возраст должен быть в диапазоне от 18 до 100 лет", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenEmailIsNull() {
        User user = new User(22, "Petr", null);

        InvalidUserException exception = assertThrows(InvalidUserException.class,
                () -> validator.validate(user));

        assertEquals("Email не должно быть пустым", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenEmailHasWrongFormat() {
        User user = new User(22, "Petr", "petrgmail.com");

        InvalidUserException exception = assertThrows(InvalidUserException.class,
                () -> validator.validate(user));

        assertEquals("Некорректный формат email", exception.getMessage());
    }

    @Test
    void shouldSkipValidationWhenValidationDisabled() {
        User user = new User(10, "petr", "wrong-email");
        UserValidator.setValidationEnabled(false);

        assertDoesNotThrow(() -> validator.validate(user));
    }
}