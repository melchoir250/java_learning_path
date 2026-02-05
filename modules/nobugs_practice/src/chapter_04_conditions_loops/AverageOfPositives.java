package chapter_04_conditions_loops;

import java.util.Scanner;

public class AverageOfPositives {
    public static void main(String[] args) {
        averagePositiv();
    }

    public static void averagePositiv() {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int count = 0;

        for (int i = 0; i < 10; i++) {
            System.out.print("Введите число: ");
            int num = scanner.nextInt();
            if (num > 0) {
                sum += num;
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Положительных чисел нет");
            return;
        }
        double average = (double) sum / count;
        System.out.println("Среднее положительных: " + average);
    }
}
