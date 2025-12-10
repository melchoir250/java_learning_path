package chapter_04_conditions_loops;

//21. Реверс числа
//Выведи цифры введённого числа в обратном порядке.

public class NumberReverser {
    public static void main(String[] args) {
        System.out.println(reverser(354));
    }

    public static int reverser(int num) {
        int result = 0;
        while (num > 0) {
            int last = num % 10;
            result = result * 10 + last;
            num = num / 10;
        }
        return result;
    }
}
