package priorityqueue;


import java.util.PriorityQueue;

public class PriorityQueueTask1_PollOrder {

    public static void main(String[] args) {
        pollOrder();
    }

    public static void pollOrder() {
        PriorityQueue<Integer> map = new PriorityQueue<>();
        map.add(3);
        map.add(201);
        map.add(32);
        map.add(55);
        map.add(15);

        while (!map.isEmpty()) {
            System.out.println(map.poll());
        }
    }
}
