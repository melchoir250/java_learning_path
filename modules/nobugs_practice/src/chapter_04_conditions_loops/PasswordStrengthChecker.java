package chapter_04_conditions_loops;

// 52. Проверка пароля на надёжность
// Пользователь вводит строку.
// Проверь, содержит ли она хотя бы одну заглавную букву,
// одну цифру и минимум 8 символов.

import java.util.Scanner;

public class PasswordStrengthChecker {
    public static void main(String[] args) {
        System.out.println(passwordStrengthCheck());
    }

    public static String passwordStrengthCheck() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();

        boolean passUpper = false;
        boolean passNumber = false;

        if (password.length() < 8) return "Пароль менее 8 символов";

        for (int i = 0; i < password.length(); i++) {
            char pass = password.charAt(i);
            if (Character.isUpperCase(pass)) passUpper = true;
            if (Character.isDigit(pass)) passNumber = true;
        }

        if (!passUpper) return "В пароле нет заглавной буквы";
        if (!passNumber) return "В пароле нет цифр";

        return "Пароль корректен";
    }
}
