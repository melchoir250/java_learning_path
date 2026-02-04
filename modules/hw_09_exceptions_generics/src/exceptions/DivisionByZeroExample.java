package exceptions;


import java.util.Scanner;

public class DivisionByZeroExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int num_first = scanner.nextInt();
        System.out.print("Введите число: ");
        int num_two = scanner.nextInt();
        divisionByZero(num_first, num_two);
    }

    public static void divisionByZero(int num1, int num2) {
        try {
            int div_num = num1 / num2;
            System.out.println("Решение: " + div_num);
        } catch (ArithmeticException e) {
            System.out.println("На ноль делить нельзя");
        }
    }
}
