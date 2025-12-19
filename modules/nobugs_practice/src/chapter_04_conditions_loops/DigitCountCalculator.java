package chapter_04_conditions_loops;

// 41. Найти общее количество цифр в числе
// Пользователь вводит целое число.
// Определи, сколько в нём цифр.

import java.util.Scanner;

public class DigitCountCalculator {
    public static void main(String[] args) {
        System.out.println(digitCount());
    }

    public static int digitCount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int digit_number = scanner.nextInt();

        int count = 0;

        if (digit_number == 0) {
            count++;
            return count;
        }

        for (; digit_number > 0; count++) {
            digit_number = digit_number / 10;
        }

        return count;
    }
}
