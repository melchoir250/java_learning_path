package treeset;


import java.util.TreeSet;

public class TreeSetTask2_NoDuplicates {

    public static void main(String[] args) {
        treeSetNoDublicate();
    }

    public static void treeSetNoDublicate() {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(1);
        treeSet.add(3);
        treeSet.add(2);
        System.out.println(treeSet);
    }
}
