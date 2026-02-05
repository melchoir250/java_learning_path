package chapter_04_conditions_loops;

// 70. Поиск повторяющихся цифр в числе
// Проверь, содержит ли введённое число хотя бы одну повторяющуюся цифру.

import java.util.Scanner;

public class RepeatingDigitsChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число: ");
        String number = scanner.nextLine();

        boolean hasRepeat = false;

        for (int i = 0; i < number.length(); i++) {
            for (int j = i + 1; j < number.length(); j++) {
                if (number.charAt(i) == number.charAt(j)) {
                    hasRepeat = true;
                    break;
                }
            }
            if (hasRepeat) {
                break;
            }
        }

        if (hasRepeat) {
            System.out.println("В числе есть повторяющиеся цифры");
        } else {
            System.out.println("Повторяющихся цифр нет");
        }
    }
}
