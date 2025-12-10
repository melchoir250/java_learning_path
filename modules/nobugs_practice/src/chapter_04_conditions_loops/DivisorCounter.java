package chapter_04_conditions_loops;

//14. Подсчёт делителей числа
//Введи число и посчитай, сколько у него натуральных делителей.

import java.util.Scanner;

public class DivisorCounter {
    public static void main(String[] args) {
        System.out.println(divCount());
    }
    public static int divCount() {
        Scanner scanner = new Scanner(System.in);
        int num;
        int count = 0;
        System.out.print("Введите число: ");
        num = scanner.nextInt();
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                count++;
            }
        }
        return count;
    }
}
