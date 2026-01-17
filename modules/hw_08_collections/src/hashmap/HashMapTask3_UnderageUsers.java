package hashmap;


import java.util.HashMap;
import java.util.Map;

public class HashMapTask3_UnderageUsers {

    public static void main(String[] args) {
        hashMapUnderageUsers();
    }

    public static void hashMapUnderageUsers() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Ivan", 22);
        map.put("Petr", 12);
        map.put("Gevorg", 14);
        map.put("Slava", 21);
        map.put("Max", 17);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() < 18) {
                System.out.printf("%s %s%n", entry.getKey(), entry.getValue());
            }
        }
    }
}
