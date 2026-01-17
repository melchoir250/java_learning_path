package linkedhashmap;


import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTask1_InsertionOrder {

    public static void main(String[] args) {
        linkedHashMapInsertionOrder();
    }

    public static void linkedHashMapInsertionOrder() {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("Ivan", 22);
        map.put("Petr", 23);
        map.put("Islam", 24);
        map.put("Arsen", 25);
        map.put("Vitaliy", 26);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.printf("%s%s%n", entry.getKey(), entry.getValue());
        }
    }
}
