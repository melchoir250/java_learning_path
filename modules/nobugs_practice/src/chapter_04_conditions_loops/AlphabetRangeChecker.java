package chapter_04_conditions_loops;

//67. Проверка, входят ли символы в алфавитный диапазон
//Введи два символа и проверь, находится ли второй между первым и 'z' по алфавиту.

import java.util.Scanner;

public class AlphabetRangeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первый символ: ");
        char start = scanner.next().charAt(0);

        System.out.print("Введите второй символ: ");
        char check = scanner.next().charAt(0);

        if (check >= start && check <= 'z') {
            System.out.println("Символ находится в диапазоне");
        } else {
            System.out.println("Символ НЕ находится в диапазоне");
        }
    }
}
