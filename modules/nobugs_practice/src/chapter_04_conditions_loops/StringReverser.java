package chapter_04_conditions_loops;

// 37. Переворот строки вручную
// Вводится строка.
// Выведи её в обратном порядке, не используя StringBuilder.reverse().

import java.util.Scanner;

public class StringReverser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String strReverse = scanner.nextLine();

        stringReverse(strReverse);
    }

    public static void stringReverse(String word) {
        String result = "";

        for (int i = word.length() - 1; i >= 0; i--) {
            result += word.charAt(i);
        }
        System.out.println(result);
    }
}
