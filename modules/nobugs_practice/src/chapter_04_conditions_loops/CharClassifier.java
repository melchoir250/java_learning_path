package chapter_04_conditions_loops;

//25. Проверка символа
//Введи один символ.
//Определи, является ли он цифрой, буквой или чем-то другим.

import java.util.Scanner;

public class CharClassifier {
    public static void main(String[] args) {
        CharClass();
    }

    public static void CharClass() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите один символ: ");
        char char_symb = scanner.next().charAt(0);

        if (Character.isDigit(char_symb)) {
            System.out.println("Это цифра");
        } else if (Character.isLetter(char_symb)) {
            System.out.println("Это буква");
        } else {
            System.out.println("Это что-то другое");
        }
    }
}
