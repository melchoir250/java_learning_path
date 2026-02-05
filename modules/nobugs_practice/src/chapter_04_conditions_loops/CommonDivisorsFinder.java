package chapter_04_conditions_loops;

import java.util.Scanner;

public class CommonDivisorsFinder {
    public static void main(String[] args) {
        commonDivisorsFinder();
    }

    public static void commonDivisorsFinder() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int num1 = scanner.nextInt();
        System.out.print("Введите число: ");
        int num2 = scanner.nextInt();

        int min = Math.min(num1, num2);

        System.out.println("Общие делители:");

        for (int i = 1; i <= min; i++) {
            if (num1 % i == 0 && num2 % i == 0) {
                System.out.println(i);
            }
        }
    }
}
