package arraydeque;


import java.util.ArrayDeque;

public class ArrayDequeTask2_Stack {

    public static void main(String[] args) {
        arrayDequeStack();
    }

    public static void arrayDequeStack() {
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        arrayDeque.push("Airbus");
        arrayDeque.push("Boing");
        arrayDeque.push("Antonov");
        arrayDeque.push("Mig");
        arrayDeque.push("Sukhoi");
        System.out.println(arrayDeque);

        while (!arrayDeque.isEmpty()) {
            System.out.println(arrayDeque.pop());
        }
    }
}
