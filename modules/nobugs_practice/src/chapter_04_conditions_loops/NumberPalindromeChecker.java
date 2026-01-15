package chapter_04_conditions_loops;

// 51. Проверка палиндрома (число)
// Вводится целое число.
// Определи, читается ли оно одинаково слева направо и справа налево.

import java.util.Scanner;

public class NumberPalindromeChecker {
    public static void main(String[] args) {
        numberPalindrome();
    }

    public static void numberPalindrome() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        String num = scanner.nextLine();

        int middle = num.length() / 2;

        String first = num.substring(0, middle);
        String second = num.substring(middle);

        if (first.length() != second.length()) {
            second = second.substring(1);
        }

        second = new StringBuilder(second).reverse().toString();

        if (first.equals(second)) {
            System.out.println("Палиндром");
        } else {
            System.out.println("Не палиндром");
        }
    }
}
