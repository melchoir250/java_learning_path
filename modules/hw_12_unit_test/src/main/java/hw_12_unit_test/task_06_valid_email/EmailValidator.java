package hw_12_unit_test.task_06_valid_email;

public class EmailValidator {
    public boolean isValidEmail(String email) {
        return email != null && email.matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$");
    }
}
