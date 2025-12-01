package chapter_03_static_final;

// 6. Проверка чётности без объекта
//Создай класс с методом, который проверяет, чётное ли число.
//Этот метод должен быть доступен без создания объекта класса.
//Пояснение: подбери подходящую структуру для вызова метода напрямую через имя
//класса.

public class NumberUtils {
    public static boolean isEven(int value) {
        return value % 2 == 0;
    }

    public static void main(String[] args) {
        System.out.println(isEven(12));
    }
}
