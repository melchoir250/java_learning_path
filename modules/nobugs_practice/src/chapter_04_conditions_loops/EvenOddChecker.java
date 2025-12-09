package chapter_04_conditions_loops;

// 1. Определение чётности числа
//Проверь, является ли введённое число чётным или нечётным. Выведи
//соответствующее сообщение.

public class EvenOddChecker {
    public static String OddCheck(int num) {
        if (num % 2 == 0) {
            return "Четное";
        } else {
            return "Нечетное";
        }
    }

    public static void main(String[] args) {
        System.out.println(OddCheck(22));
        System.out.println(OddCheck(11));
        System.out.println(OddCheck(14));
    }
}
