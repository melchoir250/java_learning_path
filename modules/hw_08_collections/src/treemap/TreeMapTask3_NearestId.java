package treemap;


import java.util.TreeMap;

public class TreeMapTask3_NearestId {

    public static void main(String[] args) {
        nearestId();
    }

    public static void nearestId() {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(1, "Ivan");
        map.put(2, "Petr");
        map.put(3, "Vasya");
        map.put(4, "Klim");
        map.put(5, "Zaur");

        System.out.println(map.higherKey(3));
    }
}
