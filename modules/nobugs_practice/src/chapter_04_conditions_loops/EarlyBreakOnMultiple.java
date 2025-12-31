package chapter_04_conditions_loops;

// 46. Цикл с досрочным завершением
// Выведи числа от 1 до 100,
// но остановись, если встретишь число, кратное 17.

public class EarlyBreakOnMultiple {
    public static void main(String[] args) {
        earlyBreakMultiply();
    }

    public static void earlyBreakMultiply() {
        for (int i = 1; i <= 100; i++) {
            if (i % 17 == 0) {
                break;

            }
            System.out.println(i);
        }
    }
}
