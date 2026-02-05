package chapter_04_conditions_loops;

import java.util.Scanner;

public class MaxDigitFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        String number = scanner.nextLine();

        int maxDigit = 0;

        for (int i = 0; i < number.length(); i++) {
            int digit = number.charAt(i) - '0';

            if (digit > maxDigit) {
                maxDigit = digit;
            }
        }
        System.out.println("Максимальная цифра: " + maxDigit);
    }
}
