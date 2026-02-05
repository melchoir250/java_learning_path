package chapter_04_conditions_loops;

//66. Нахождение общих цифр двух чисел
//Пользователь вводит два числа. Определи, какие цифры встречаются в обоих числах.

import java.util.Scanner;

public class CommonDigitsFinder {
    public static void main(String[] args) {
        findCommonDigits();
    }

    public static void findCommonDigits() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        String num1 = scanner.nextLine();

        System.out.print("Введите второе число: ");
        String num2 = scanner.nextLine();

        System.out.println("Общие цифры:");

        for (int i = 0; i < num1.length(); i++) {
            char digit = num1.charAt(i);

            if (num2.indexOf(digit) != -1) {
                System.out.println(digit);
            }
        }
    }
}
