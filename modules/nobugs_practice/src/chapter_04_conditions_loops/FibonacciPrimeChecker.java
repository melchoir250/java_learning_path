package chapter_04_conditions_loops;

// 44. Простое ли число Фибоначчи
// Вводится число.
// Определи, входит ли оно в последовательность Фибоначчи и является ли простым.

import java.util.Scanner;

public class FibonacciPrimeChecker {
    public static void main(String[] args) {
        fibonacciPrime();
    }


    public static void fibonacciPrime() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int num = scanner.nextInt();

        if (num == 0 || num == 1) {
            System.out.println("Это число Фибоначчи");
            return;
        }

        int a = 0;
        int b = 1;

        while (b < num) {
            int temp = a + b;
            a = b;
            b = temp;
        }

        if (b == num) {
            System.out.println("Это число Фибоначчи");
        } else {
            System.out.println("Это число не Фибоначчи");
        }
    }
}