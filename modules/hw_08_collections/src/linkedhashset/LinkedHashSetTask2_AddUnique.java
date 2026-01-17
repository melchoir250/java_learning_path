package linkedhashset;


import java.util.LinkedHashSet;

public class LinkedHashSetTask2_AddUnique {

    public static void main(String[] args) {
        LinkedHashSet<String> set = new LinkedHashSet<>();
        addUnique(set, "Java");
        addUnique(set, "Python");
        addUnique(set, "Java");
        addUnique(set, "Goalng");

        System.out.println(set);
    }


    public static void addUnique(LinkedHashSet<String> set, String element) {
        if (!set.contains(element)) {
            set.add(element);
        }
    }
}
