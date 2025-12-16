package chapter_04_conditions_loops;

// 32. Мини-калькулятор
// Вводятся два числа и оператор (+, -, *, /).
// Выполни соответствующее арифметическое действие.

import java.util.Scanner;

public class MiniCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        int num1 = scanner.nextInt();
        System.out.print("Введите второе число: ");
        int num2 = scanner.nextInt();
        System.out.print("Введите оператор: ");
        char operator = scanner.next().charAt(0);
        System.out.println(calculator(num1, num2, operator));
    }

    public static double calculator(int number1, int number2, char operator) {
        if (operator == '+') {
            return number1 + number2;
        } else if (operator == '-') {
            return number1 - number2;
        } else if (operator == '*') {
            return number1 * number2;
        } else if (operator == '/') {
            if (number2 == 0) {
                throw new IllegalArgumentException("На ноль делить нельзя " + number2);
            }
            return (double) number1 / number2;
        } else {
            throw new IllegalArgumentException("Неизвестный оператор: " + operator);
        }
    }
}
