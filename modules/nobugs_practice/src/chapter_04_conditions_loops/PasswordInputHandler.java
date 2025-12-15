package chapter_04_conditions_loops;

// 30. Проверка пароля с досрочным выходом
//Программа предлагает ввести пароль до 5 раз. Если пользователь вводит "exit"
//программа завершается сразу.

import java.util.Scanner;

public class PasswordInputHandler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int count = 1; count <= 5; count++) {
            System.out.print("Введите пароль: ");
            String password = scanner.nextLine();

            if (password.equals("exit")) {
                System.out.println("Программа завершена");
                return;
            }

            if (password.equals("admin")) {
                System.out.println("Пароль введён верно");
                return;
            }

            System.out.println("Пароль не валидный");
        }

        System.out.println("Превышен лимит ввода пароля");
    }
}
