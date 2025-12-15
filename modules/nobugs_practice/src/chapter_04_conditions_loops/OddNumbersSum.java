package chapter_04_conditions_loops;

//26. Сумма только нечётных чисел от 1 до N
//Подсчитай сумму всех нечётных чисел от 1 до заданного N.

import java.util.Scanner;

public class OddNumbersSum {
    public static void main(String[] args) {
        System.out.println(OddNumber());
    }

    public static int OddNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int num = scanner.nextInt();
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            if (i % 2 != 0) {
                sum += i;
            }
        }
        return sum;
    }
}
