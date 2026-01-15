package chapter_04_conditions_loops;

// 49. Разделение строки на слова
// Пользователь вводит строку.
// Раздели её на слова и выведи каждое слово на новой строке.

import java.util.Scanner;

public class WordsSplitter {
    public static void main(String[] args) {
        wordsSplit();
    }

    public static void wordsSplit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String words = scanner.nextLine();

        String[] words_split = words.split("\\s+");

        for (int i = 0; i < words_split.length; i++) {
            System.out.println(words_split[i]);
        }
    }
}
