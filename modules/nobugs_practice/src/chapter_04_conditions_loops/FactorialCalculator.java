package chapter_04_conditions_loops;

//15. Факториал числа
//Вычисли факториал введённого числа n, используя цикл.

import java.util.Scanner;

public class FactorialCalculator {
    public static void main(String[] args) {
        System.out.println(factorialNum());
    }

    public static int factorialNum() {
        Scanner scanner = new Scanner(System.in);
        int num = 1;
        System.out.print("Введите число: ");
        int number = scanner.nextInt();
        for (int i = 1; i <= number; i++) {
            num *= i;
        }
        return num;
    }
}
