package chapter_04_conditions_loops;

// 43. Проверка начальной буквы
// Вводится строка.
// Определи, начинается ли она с заглавной буквы.

import java.util.Scanner;

public class CapitalLetterChecker {
    public static void main(String[] args) {
        capitalLetter();
    }

    public static void capitalLetter() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String str_slove = scanner.nextLine();
        if (str_slove.isEmpty()) {
            System.out.println("Строка не может быть пустой");
        }
        char char_slove = str_slove.charAt(0);
        if (Character.isUpperCase(char_slove)) {
            System.out.println("Строка начинается с заглавной буквы");
        } else {
            System.out.println("Строка не начинается с заглавной буквы");
        }
    }
}
