package chapter_04_conditions_loops;

//24. Циклическое меню
//1. Старт
//2. Помощь
//0. Выход
//Меню повторяется, пока пользователь не выберет 0.

import java.util.Scanner;

public class ConsoleMenu {
    public static void main(String[] args) {
        console();
    }

    public static void console() {
        Scanner scanner = new Scanner(System.in);
        int num = -1;

        while (num != 0) {
            System.out.println("1. Старт");
            System.out.println("2. Помощь");
            System.out.println("0. Выход");
            num = scanner.nextInt();

            if (num == 1) {
                System.out.println("Старт!");
            } else if (num == 2) {
                System.out.println("Помощь:");
            } else if (num != 0) {
                System.out.println("Неизвестная команда");
            }
        }
        System.out.println("Выход");
    }
}
