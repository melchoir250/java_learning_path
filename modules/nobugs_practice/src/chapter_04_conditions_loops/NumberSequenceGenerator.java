package chapter_04_conditions_loops;

// 35. Генерация числовой последовательности
// Пользователь вводит начало, конец и шаг.
// Выведи все числа в этом диапазоне, включая крайние значения.

import java.util.Scanner;

public class NumberSequenceGenerator {
    public static void main(String[] args) {
        numberSequence();
    }

    public static void numberSequence() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите начало: ");
        int begin = scanner.nextInt();

        System.out.print("Введите конец: ");
        int end = scanner.nextInt();

        System.out.print("Введите шаг: ");
        int step = scanner.nextInt();

        if (step == 0) {
            System.out.println("Шаг не может быть равен 0");
            return;
        }

        for (; begin <= end; begin += step) {
            System.out.println(begin);
        }
    }
}
