package hw_13_debugging.task_10_list_remove;

import java.util.*;

public class DebugTask10 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie"));

        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            if (name.startsWith("A")) {
                iterator.remove();
            }
        }
        System.out.println(names);
    }
}