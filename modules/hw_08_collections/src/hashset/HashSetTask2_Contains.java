package hashset;


import java.util.HashSet;

public class HashSetTask2_Contains {

    public static void main(String[] args) {
        hashSetContains();
    }

    public static void hashSetContains() {
        HashSet<Integer> nums = new HashSet<>();
        nums.add(0);
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);
        nums.add(6);
        nums.add(7);
        nums.add(8);
        nums.add(9);
        nums.add(10);

        System.out.println("Check nubmer: " + nums.contains(7));
        System.out.println("Check nubmer: " + nums.contains(5));
        System.out.println("Check nubmer: " + nums.contains(15));
    }
}
