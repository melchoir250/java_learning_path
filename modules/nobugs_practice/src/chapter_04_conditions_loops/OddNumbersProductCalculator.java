package chapter_04_conditions_loops;

// 48. Умножение всех нечётных чисел от 1 до 15
// Посчитай произведение всех нечётных чисел от 1 до 15 включительно.

public class OddNumbersProductCalculator {
    public static void main(String[] args) {
        System.out.println(oddNumber());
    }

    public static int oddNumber() {
        int sum = 1;

        for (int i = 1; i <= 15; i++) {
            if (i % 2 != 0) {
                sum *= i;
            }
        }
        return sum;
    }
}
