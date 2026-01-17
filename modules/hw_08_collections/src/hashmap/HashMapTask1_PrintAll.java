package hashmap;


import java.util.HashMap;
import java.util.Map;

public class HashMapTask1_PrintAll {

    public static void main(String[] args) {
        hashMapPrintAll();
    }

    public static void hashMapPrintAll() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Ivan", 22);
        map.put("Petr", 55);
        map.put("Gevorg", 44);
        map.put("Slava", 11);
        map.put("Max", 39);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
