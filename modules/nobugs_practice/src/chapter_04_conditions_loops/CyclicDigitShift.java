package chapter_04_conditions_loops;

import java.util.Scanner;

public class CyclicDigitShift {
    public static void main(String[] args) {
        cyclicDigit();
    }

    public static void cyclicDigit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        String num = scanner.nextLine();
        if (num.length() <= 1) {
            System.out.println(num);
            return;
        }
        char first = num.charAt(0);
        String rest = num.substring(1);
        String result = rest + first;
        System.out.println(result);
    }
}
