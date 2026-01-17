package treeset;


import java.util.TreeSet;

public class TreeSetTask1_SortedPrint {

    public static void main(String[] args) {
        treeSetTaskSortedPrint();
    }

    public static void treeSetTaskSortedPrint() {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(7);
        treeSet.add(44);
        treeSet.add(94);
        treeSet.add(3);

        System.out.println(treeSet);
    }
}
