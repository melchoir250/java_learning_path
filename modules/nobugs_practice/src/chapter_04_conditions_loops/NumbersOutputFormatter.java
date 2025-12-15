package chapter_04_conditions_loops;

// 29. Вывод чисел в столбик и в строку
//Выведи числа от 1 до 10: сначала каждое в новой строке, затем — все в одной строке
//через пробел.

public class NumbersOutputFormatter {
    public static void main(String[] args) {
        numbOutputFormat();
    }

    public static void numbOutputFormat() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }

        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
        }
    }
}
