package chapter_04_conditions_loops;

//19. Поиск максимального числа в серии
//Пользователь вводит числа до ввода нуля.
//Найди максимальное число из всех введённых.

import java.util.Scanner;

public class MaxInSeriesFinder {
    public static void main(String[] args) {
        System.out.println(MaxSeries());
    }
    public static int MaxSeries() {
        Scanner scanner = new Scanner(System.in);
        int maxNum = Integer.MIN_VALUE;
        while (true) {
            System.out.print("Введите число: ");
            int num = scanner.nextInt();
            if (num == 0) {
                break;
            }
            if (num > maxNum) {
                maxNum = num;
            }
        }
        return maxNum;
    }
}
