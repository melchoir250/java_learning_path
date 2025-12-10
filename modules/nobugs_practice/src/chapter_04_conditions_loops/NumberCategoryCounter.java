package chapter_04_conditions_loops;

//20. Кол-во положительных, отрицательных и нулей
//Пользователь вводит 10 чисел.
//Посчитай, сколько из них положительные, отрицательные и нули.

import java.util.Scanner;

public class NumberCategoryCounter {
    public static void main(String[] args) {
        System.out.println(categoryNumber());
    }

    public static String categoryNumber() {
        Scanner scanner = new Scanner(System.in);
        int num_zero = 0;
        int num_positiv = 0;
        int num_negativ = 0;
        for (int i = 1; i <= 10; i++) {
            System.out.print("Введите число: ");
            int num = scanner.nextInt();

            if (num > 0) {
                num_positiv++;
            } else if (num == 0) {
                num_zero++;
            } else {
                num_negativ++;
            }
        }
        return "Позитивных чисел: " + num_positiv +
                ", Отрицательных чисел: " + num_negativ +
                ", Нулей: " + num_zero;
    }
}
