package chapter_04_conditions_loops;

// 42. Условный вывод строки
// Вводится строка и число.
// Если длина строки больше введённого числа — выведи строку в верхнем регистре.
// Иначе — в нижнем.

import java.util.Scanner;

public class ConditionalStringFormatter {
    public static void main(String[] args) {
        conditionalFormating();
    }

    public static void conditionalFormating() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String str_slove = scanner.nextLine();
        System.out.print("Введите строку: ");
        int int_num = scanner.nextInt();
        int len_slive = str_slove.length();

        if (int_num < len_slive) {
            System.out.println(str_slove.toUpperCase());
        } else {
            System.out.println(str_slove.toLowerCase());
        }
    }
}
