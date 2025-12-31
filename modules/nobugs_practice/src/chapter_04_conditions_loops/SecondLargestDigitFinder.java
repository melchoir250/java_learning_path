package chapter_04_conditions_loops;

// 45. Поиск второй по величине цифры.
// Вводится число.
// Найди вторую по величине цифру (не сортируя весь список).

import java.util.Scanner;

public class SecondLargestDigitFinder {
    public static void main(String[] args) {
        secondLargeDigit();
    }

    public static void secondLargeDigit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int num = Math.abs(scanner.nextInt());

        int max = -1;
        int secondMax = -1;

        while (num > 0) {
            int digit = num % 10;

            if (digit > max) {
                secondMax = max;
                max = digit;
            } else if (digit < max && digit > secondMax) {
                secondMax = digit;
            }

            num = num / 10;
        }

        if (secondMax == -1) {
            System.out.println("Вторая по величине цифра отсутствует");
        } else {
            System.out.println("Вторая по величине цифра: " + secondMax);
        }
    }
}
