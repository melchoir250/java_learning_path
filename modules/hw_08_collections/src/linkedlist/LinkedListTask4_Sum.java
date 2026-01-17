package linkedlist;


import java.util.Arrays;
import java.util.LinkedList;

public class LinkedListTask4_Sum {

    public static void main(String[] args) {
        linkedListSum();
    }

    public static void linkedListSum() {
        LinkedList<Integer> lists = new LinkedList<>(Arrays.asList(12, 13, 15, 18, 17, 25));

        int sum = 0;

        for (int list : lists) {
            sum += list;
        }
        System.out.println("Sum = " + sum);
    }
}
