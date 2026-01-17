package treeset;


import java.util.Arrays;
import java.util.TreeSet;

public class TreeSetTask3_NearestValues {

    public static void main(String[] args) {
        treeSetNearestValues();
    }

    public static void treeSetNearestValues() {
        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(10, 20, 30, 40, 50));

        System.out.println(treeSet.higher(25));
        System.out.println(treeSet.lower(25));
    }
}
