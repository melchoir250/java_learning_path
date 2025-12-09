package chapter_04_conditions_loops;

// 6. Сравнение трёх чисел
//Вводятся три числа. Определи наибольшее из них.

public class MaxOfThreeCalculator {
    public static int MaxTree(int num1, int num2, int num3) {
        return Math.max(num1, Math.max(num2, num3));
    }

    public static void main(String[] args) {
        System.out.println(MaxTree(12, 13, 15));
    }
}
