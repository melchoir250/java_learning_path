package treemap;


import java.util.TreeMap;

public class TreeMapTask2_MinMaxKey {

    public static void main(String[] args) {
        minMaxKey();
    }

    public static void minMaxKey() {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(1, "Ivan");
        map.put(2, "Petr");
        map.put(3, "Vasya");
        map.put(4, "Klim");
        map.put(5, "Zaur");

        System.out.println("Минимальный ключ: " + map.firstKey());
        System.out.println("Максимальный ключ: " + map.lastKey());
    }
}
