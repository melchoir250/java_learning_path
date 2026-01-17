package treemap;


import java.util.Map;
import java.util.TreeMap;

public class TreeMapTask1_SortedPrint {

    public static void main(String[] args) {
        treeMapSortedPrint();
    }

    public static void treeMapSortedPrint() {
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("Ivan", 12);
        map.put("Svyat", 112);
        map.put("Kolya", 42);
        map.put("Max", 34);
        map.put("Petr", 22);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
