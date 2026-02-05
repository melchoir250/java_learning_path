package chapter_04_conditions_loops;

import java.util.Scanner;

public class VowelPresenceChecker {
    public static void main(String[] args) {
        vowelPresenceCheck();
    }

    public static void vowelPresenceCheck() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String word = scanner.nextLine().toLowerCase();

        String vowels = "aeiou";
        boolean hasVowel = false;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (vowels.indexOf(ch) != -1) {
                hasVowel = true;
                break;
            }
        }

        System.out.println(hasVowel
                ? "В строке есть гласная"
                : "Гласных нет");
    }
}
