package chapter_04_conditions_loops;

// 36. Пропустить чётные числа
// Выведи числа от 1 до 20, исключая все чётные.

public class OddNumberPrinter {
    public static void main(String[] args) {
        oddNumber();
    }

    public static void oddNumber() {
        for (int i = 1; i <= 20; i++) {
            if (i % 2 == 0) {
                continue;
            }
            System.out.println(i);
        }
    }
}
