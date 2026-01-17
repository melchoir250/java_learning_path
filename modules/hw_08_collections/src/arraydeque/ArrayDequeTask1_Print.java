package arraydeque;


import java.util.ArrayDeque;

public class ArrayDequeTask1_Print {

    public static void main(String[] args) {
        arrayDequePrint();
    }

    public static void arrayDequePrint() {
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        arrayDeque.add("Airbus");
        arrayDeque.add("Boing");
        arrayDeque.add("Antonov");
        arrayDeque.add("Mig");
        arrayDeque.add("Sukhoi");

        System.out.println(arrayDeque);
    }
}
