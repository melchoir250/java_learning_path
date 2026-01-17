package linkedlist;


import java.util.Arrays;
import java.util.LinkedList;

public class LinkedListTask3_FirstAndLast {

    public static void main(String[] args) {
        linkedListFirstAndLast();
    }

    public static void linkedListFirstAndLast() {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("One", "Two", "Tree"));
        System.out.println(list);
        System.out.println("Получение первого элемента: " + list.getFirst());
        System.out.println("Получение последнего элемента: " + list.getLast());
    }
}
