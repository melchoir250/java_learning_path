package task_02_user_validator;

import java.util.regex.Pattern;

public class UserValidator {
    private static boolean validationEnabled = true;

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    public static boolean isValidationEnabled() {
        return validationEnabled;
    }

    public static void setValidationEnabled(boolean validationEnabled) {
        UserValidator.validationEnabled = validationEnabled;
    }

    public void validate(User user) {
        if (!validationEnabled) {
            return;
        }

        if (user == null) {
            throw new InvalidUserException("Пользователь не должен быть null");
        }

        validateName(user.getName());
        validateAge(user.getAge());
        validateEmail(user.getEmail());
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new InvalidUserException("Имя не должно быть пустым");
        }

        if (!Character.isUpperCase(name.charAt(0))) {
            throw new InvalidUserException("Имя должно начинаться с заглавной буквы");
        }
    }

    public void validateAge(int age) {
        if (age < 18 || age > 100) {
            throw new InvalidUserException("Возраст должен быть в диапазоне от 18 до 100 лет");
        }
    }

    public void validateEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new InvalidUserException("Email не должно быть пустым");
        }

        if (!EMAIL_PATTERN.matcher(email).matches()) {
            throw new InvalidUserException("Некорректный формат email");
        }
    }
}