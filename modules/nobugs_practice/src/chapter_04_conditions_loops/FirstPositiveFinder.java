package chapter_04_conditions_loops;

// 38. Поиск первого положительного числа
// Пользователь вводит числа по одному.
// Найди и выведи первое положительное.

import javax.swing.*;
import java.util.Scanner;

public class FirstPositiveFinder {
    public static void main(String[] args) {
        int res = firstPositive();
        System.out.println("Первое положительное число: " + res);
    }

    public static int firstPositive() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число: ");
        int firstFind = scanner.nextInt();

        while (firstFind <= 0) {
            System.out.print("Введите число: ");
            firstFind = scanner.nextInt();
        }

        return firstFind;
    }
}