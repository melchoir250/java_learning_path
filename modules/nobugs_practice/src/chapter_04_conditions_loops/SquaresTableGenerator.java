package chapter_04_conditions_loops;

// 28. Таблица квадратов чисел
//Выведи таблицу квадратов чисел от 1 до 10.

public class SquaresTableGenerator {
    public static void main(String[] args) {
        squareTable();
    }

    public static void squareTable() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + " * " + i + " = " + (i * i));
        }
    }
}
