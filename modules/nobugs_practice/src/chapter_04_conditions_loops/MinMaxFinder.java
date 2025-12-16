package chapter_04_conditions_loops;

// 34. Поиск максимального и минимального
// Пользователь вводит 5 чисел.
// Найди и выведи наибольшее и наименьшее из них.

import java.util.Scanner;

public class MinMaxFinder {
    public static void main(String[] args) {
        System.out.println(maxFinder());
    }

    public static String maxFinder() {
        Scanner scanner = new Scanner(System.in);
        int count = 1;

        int min_num = Integer.MAX_VALUE;
        int max_num = Integer.MIN_VALUE;
        while (count <= 5) {
            count++;
            System.out.print("Введите число: ");
            int num = scanner.nextInt();
            if (num > max_num) {
                max_num = num;
            }
            if (num < min_num) {
                min_num = num;
            }
        }
        return "Min: " + min_num + ", Max: " + max_num;
    }
}
