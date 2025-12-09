package chapter_04_conditions_loops;

// 10. Таблица умножения для числа
//Пользователь вводит число. Построй таблицу умножения от 1 до 10 для этого числа.

public class MultiplicationTableGenerator {
    public static void multTable(int num) {
        for (int i = 1; i <= 10; i++) {
            int res = i * num;
            System.out.println(num + " * " + i + " = " + res);
        }
    }
    public static void main(String[] args) {
        multTable(5);
    }
}
