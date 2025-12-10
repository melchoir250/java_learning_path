package chapter_04_conditions_loops;

//17. Проверка на простое число
//Определи, является ли число простым.

import java.util.Scanner;

public class PrimeChecker {
    public static void main(String[] args) {
        System.out.println(primeCheck());
    }

    public static String primeCheck() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int num = scanner.nextInt();
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                count++;
            }
        }
        if (count == 2) {
            return "Число простое";
        } else {
            return "Число не простое";
        }
    }
}

