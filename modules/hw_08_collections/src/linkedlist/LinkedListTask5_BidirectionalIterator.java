package linkedlist;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListTask5_BidirectionalIterator {

    public static void main(String[] args) {
        linkedListIterator();
    }

    public static void linkedListIterator() {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("One", "Two", "Tree"));
        ListIterator<String> lst = list.listIterator();

        while (lst.hasNext()) {
            System.out.println("Идем вперед: " + lst.next());
        }

        while (lst.hasPrevious()) {
            System.out.println("Идем назад: " + lst.previous());
        }
    }
}
