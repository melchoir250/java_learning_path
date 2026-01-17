package linkedlist;


import java.util.LinkedList;

public class LinkedListTask1_PrintAll {

    public static void main(String[] args) {
        linkedListPrintAll();
    }

    public static void linkedListPrintAll() {
        LinkedList<String> list = new LinkedList<>();

        list.add("car");
        list.add("plane");
        list.add("man");
        list.add("family");
        System.out.println(list);
    }
}
