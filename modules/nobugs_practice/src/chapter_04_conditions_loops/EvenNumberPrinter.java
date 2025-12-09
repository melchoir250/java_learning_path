package chapter_04_conditions_loops;

//7. Чётные числа от 1 до N
//Выведи все чётные числа от 1 до заданного числа N.

public class EvenNumberPrinter {
    public static void NumPrint(int num) {
        for (int i = 1; i <= num; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
    public static void main(String[] args) {
        NumPrint(15);
    }
}
