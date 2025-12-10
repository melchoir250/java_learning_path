package chapter_04_conditions_loops;

//13. Обратный отсчёт
//Выведи числа от 10 до 1 в обратном порядке. В конце —"Старт!"

public class CountdownPrinter {
    public static void main(String[] args) {
        numPrint();
    }
    public static void numPrint() {
        for (int i = 10; i >= 1; i--) {
            System.out.println(i);
        }
    }
}
