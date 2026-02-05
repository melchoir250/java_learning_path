package chapter_04_conditions_loops;

import java.util.Scanner;

public class SumUntilZero {
    public static void main(String[] args) {
        sumUntil();
    }

    public static void sumUntil() {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        for (int i=0; ; ) {
            System.out.print("Введите число: ");
            int number = scanner.nextInt();
            if (number == 0) {
                break;
            }
            sum += number;
        }
        System.out.println(sum);
    }
}
