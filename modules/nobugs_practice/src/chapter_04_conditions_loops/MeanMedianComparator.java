package chapter_04_conditions_loops;

import java.util.Arrays;
import java.util.Scanner;

public class MeanMedianComparator {
    public static void main(String[] args) {
        meanMedianComp();
    }

    public static void meanMedianComp() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int num1 = scanner.nextInt();
        System.out.print("Введите число: ");
        int num2 = scanner.nextInt();
        System.out.print("Введите число: ");
        int num3 = scanner.nextInt();

        int sum = (num1 + num2 + num3) / 3;
        System.out.println("Среднее арифметическое: " + sum);

        int[] arr = {num1, num2, num3};
        Arrays.sort(arr);
        System.out.println("Медиана: " + arr[1]);
    }
}
