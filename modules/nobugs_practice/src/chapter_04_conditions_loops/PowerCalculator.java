package chapter_04_conditions_loops;

// 69. Калькулятор степеней
// Введи основание и степень.
// Посчитай результат возведения в степень без использования Math.pow().

import java.util.Scanner;

public class PowerCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите основание: ");
        int base = scanner.nextInt();

        System.out.print("Введите степень: ");
        int power = scanner.nextInt();

        int result = 1;

        for (int i = 0; i < power; i++) {
            result *= base;
        }

        System.out.println("Результат: " + result);
    }
}
