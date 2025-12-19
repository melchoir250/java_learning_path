package chapter_04_conditions_loops;

// 40. Угадай пароль из ограниченного списка
// Есть список допустимых паролей ("admin", "user123", "qwerty").
// Пользователь вводит пароль.
// Разреши доступ, если он есть в списке.

import java.util.Scanner;

public class PasswordWhitelistChecker {
    public static void main(String[] args) {
        passwordWhiteList();
    }

    public static void passwordWhiteList() {
        String PASSWORD1 = "admin";
        String PASSWORD2 = "user123";
        String PASSWORD3 = "qwerty";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите пароль: ");
        String new_password = scanner.nextLine();
        boolean password_check = false;

        if (
                new_password.equals(PASSWORD1) ||
                        new_password.equals(PASSWORD2) ||
                        new_password.equals(PASSWORD3)
        ) {
            password_check = true;
        }
        System.out.println("Доступ: " + password_check);
    }
}
