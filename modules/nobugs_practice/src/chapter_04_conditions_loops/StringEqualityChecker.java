package chapter_04_conditions_loops;

// 33. Сравнение строк
// Вводятся две строки.
// Определи, равны ли они, не используя ==.

import java.util.Scanner;

public class StringEqualityChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите 1-ую строку: ");
        String equalCheck1 = scanner.nextLine();
        System.out.print("Введите 2-ую строку: ");
        String equalCheck2 = scanner.nextLine();
        strEquals(equalCheck1, equalCheck2);
    }

    public static void strEquals(String stringEquals1, String stringEquals2) {
        if (stringEquals1.equals(stringEquals2)) {
            System.out.println("Строки равны");
        } else {
            System.out.println("Строки не равны");
        }
    }
}
