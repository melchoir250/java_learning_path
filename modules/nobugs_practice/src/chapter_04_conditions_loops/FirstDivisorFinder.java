package chapter_04_conditions_loops;

//16. Поиск первого делителя
//Введи число и найди его первый делитель, отличный от 1.

import java.util.Scanner;

public class FirstDivisorFinder {
    public static void main(String[] args) {
        System.out.println(firstDiv());
    }

    public static int firstDiv() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int num = scanner.nextInt();
        for (int i = 2; i <= num; i++) {
            if (num % i == 0) {
                return i;
            }
        }
        return num;
    }
}
