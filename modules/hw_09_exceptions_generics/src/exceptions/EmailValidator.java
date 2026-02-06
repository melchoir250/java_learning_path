package exceptions;


import java.util.Scanner;
import java.util.regex.Pattern;

public class EmailValidator {
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Za-z0-9](?:[A-Za-z0-9_%+-]{0,62}[A-Za-z0-9])?" +
                    "(?:\\.[A-Za-z0-9_%+-]+)*" +
                    "@" +
                    "(?:[A-Za-z0-9](?:[A-Za-z0-9-]{0,61}[A-Za-z0-9])?\\.)+" +
                    "[A-Za-z]{2,}$"
    );

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите email: ");
        String email = scanner.nextLine();
        try {
            emailValidator(email);
            System.out.println("Email valid");
        } catch (InvalidEmailException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void emailValidator(String email) {
        if (email == null) {
            throw new InvalidEmailException("Email не должен быть null");
        }
        String trimmed = email.trim();
        if (trimmed.isEmpty()) {
            throw new InvalidEmailException("Email не должен быть пустым");
        }
        if (trimmed.contains(" ")) {
            throw new InvalidEmailException("Email не должен содержать пробелы");
        }
        if (trimmed.contains("..")) {
            throw new InvalidEmailException("Email не должен содержать две точки подряд");
        }
        if (!EMAIL_PATTERN.matcher(trimmed).matches()) {
            throw new InvalidEmailException("Некорректный Email");
        }
    }
}
