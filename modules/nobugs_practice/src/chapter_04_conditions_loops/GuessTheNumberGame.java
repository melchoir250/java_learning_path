package chapter_04_conditions_loops;

//23. Угадать число
//Программа случайно загадывает число от 1 до 100.
//Пользователь пытается угадать.
//Программа подсказывает: больше/меньше.
//Игра продолжается, пока число не угадано.

import java.util.Scanner;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        guessNumb(234);
    }

    public static void guessNumb(int num) {
        Scanner scanner = new Scanner(System.in);
        int number = -1;
        while (number != num) {
            System.out.print("Введите число: ");
            number = scanner.nextInt();

            if (number < num) {
                System.out.println("Загаданное число меньше");
            } else if (number > num) {
                System.out.println("Загаданное число больше");
            }
        }

        System.out.println("Число угадано!");
    }
}
