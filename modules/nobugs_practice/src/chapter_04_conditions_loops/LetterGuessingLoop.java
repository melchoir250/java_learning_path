package chapter_04_conditions_loops;

// 50. Цикл угадывания букв
// В программе хранится скрытая буква (например, 'g').
// Пользователь вводит символы по одному, пока не угадает её.
// Подскажи: "раньше" или "позже" по алфавиту.

import java.util.Scanner;

public class LetterGuessingLoop {
    public static void main(String[] args) {
        letterGuess();
    }

    public static void letterGuess() {
        Scanner scanner = new Scanner(System.in);
        char word = 'g';
        for (;;) {
            System.out.print("Введите букву: ");
            String input = scanner.nextLine();
            char userChar = input.charAt(0);
            if (word < userChar) {
                System.out.println("раньше");
            } else if (word > userChar) {
                System.out.println("позже");
            } else {
                break;
            }
        }
        System.out.println("угадал");
    }

}
