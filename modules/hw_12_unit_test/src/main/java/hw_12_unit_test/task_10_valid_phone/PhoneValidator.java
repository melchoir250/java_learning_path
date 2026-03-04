package hw_12_unit_test.task_10_valid_phone;

public class PhoneValidator {
    public boolean isValidPhoneNumber(String phone) {
        return phone.matches("\\+\\d{1,3} \\d{10}");
    }
}
