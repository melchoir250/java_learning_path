package chapter_04_conditions_loops;

// 9. Умножение без оператора *
//Выполни умножение двух положительных чисел с помощью цикла и сложения.

public class ManualMultiplier {
    public static int multiplier(int num1, int num2) {
        int res = 0;
        for (int i = 0; i < num2; i++) {
            res = res + num1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(multiplier(5, 3));
    }
}
