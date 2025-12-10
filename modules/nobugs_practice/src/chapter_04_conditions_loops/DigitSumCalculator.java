package chapter_04_conditions_loops;

//18. Найти сумму цифр числа
//Введи целое число. Посчитай сумму всех его цифр.

import java.util.Scanner;

public class DigitSumCalculator {
    public static void main(String[] args) {
        System.out.println(DigitSum());
    }
    public static int DigitSum() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int num = scanner.nextInt();
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
