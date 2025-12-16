package chapter_04_conditions_loops;

// 39. Проверка ввода на цифру
// Пользователь вводит символ.
// Определи, является ли он одной из цифр от 0 до 9.

import java.util.Scanner;

public class DigitChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите символ: ");
        char input = scanner.next().charAt(0);
        System.out.println(digitCheck(input));
    }

    public static String digitCheck(char digit) {
        if (digit >= '0' & digit <= '9') {
            return "Это цифра";
        } else {
            return "Это не цифра";
        }
    }
}
