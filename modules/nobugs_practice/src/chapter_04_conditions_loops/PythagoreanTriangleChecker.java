package chapter_04_conditions_loops;

import java.util.Scanner;

public class PythagoreanTriangleChecker {
    public static void main(String[] args) {
        PythagoreanTriangleCheck();
    }

    public static void PythagoreanTriangleCheck() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите длину: ");
        int len = scanner.nextInt();
        System.out.print("Введите ширину: ");
        int shir = scanner.nextInt();
        System.out.print("Введите высота: ");
        int height = scanner.nextInt();

        int max = Math.max(len, Math.max(shir, height));
        boolean isRightTriangle;

        if (max == len) {
            isRightTriangle = len * len == shir * shir + height * height;
        } else if (max == shir) {
            isRightTriangle = shir * shir == len * len + height * height;
        } else {
            isRightTriangle = height * height == len * len + shir * shir;
        }

        if (isRightTriangle) {
            System.out.println("Это прямоугольный треугольник");
        } else {
            System.out.println("Это НЕ прямоугольный треугольник");
        }
    }
}
