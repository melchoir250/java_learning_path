package chapter_04_conditions_loops;

import java.util.Scanner;

public class RectanglePrinter {
    public static void main(String[] args) {
        rectanglePrint();
    }

    public static void rectanglePrint() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите длину: ");
        int len = scanner.nextInt();
        System.out.print("Введите высота: ");
        int height = scanner.nextInt();
        System.out.print("Введите символ: ");
        char symbol = scanner.next().charAt(0);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < len; j++) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }
}
