package linkedhashset;


import java.util.LinkedHashSet;

public class LinkedHashSetTask1_OrderCheck {

    public static void main(String[] args) {
        linkedHashSetOrderCheck();
    }

    public static void linkedHashSetOrderCheck() {
        LinkedHashSet<String> list = new LinkedHashSet<>();

        list.add("one");
        list.add("two");
        list.add("tree");
        list.add("four");

        System.out.println(list);
    }
}
