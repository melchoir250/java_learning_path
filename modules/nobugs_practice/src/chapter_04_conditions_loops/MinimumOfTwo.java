package chapter_04_conditions_loops;

// 3. Минимум из двух чисел
// Сравни два числа и выведи меньшее из них.

public class MinimumOfTwo {
    public static int minNum(int num1, int num2) {
//        if (num1 > num2) {
//            return num2;
//        } else {
//            return num1;
//        }
        return Math.min(num1, num2);
    }

    public static void main(String[] args) {
        System.out.println(minNum(12, 134));
    }
}
