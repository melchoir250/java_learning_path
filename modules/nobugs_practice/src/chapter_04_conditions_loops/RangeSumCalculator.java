package chapter_04_conditions_loops;

// 8. Сумма чисел от 1 до 100
//Посчитай сумму всех чисел от 1 до 100 включительно.

public class RangeSumCalculator {
    public static int SumCalc() {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum = sum + i;
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(SumCalc());
    }
}
