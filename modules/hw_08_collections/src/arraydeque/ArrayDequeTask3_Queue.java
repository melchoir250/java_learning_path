package arraydeque;


import java.util.ArrayDeque;

public class ArrayDequeTask3_Queue {

    public static void main(String[] args) {
        arrayDequeQueue();
    }

    public static void arrayDequeQueue() {
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();

        arrayDeque.addFirst("Airbus");
        arrayDeque.addLast("Boing");
        arrayDeque.addFirst("Antonov");
        arrayDeque.addLast("Mig");
        arrayDeque.addLast("Sukhoi");

        System.out.println(arrayDeque);

        while (!arrayDeque.isEmpty()) {
            System.out.println( arrayDeque.removeFirst());
            System.out.println(arrayDeque);
        }
    }
}
