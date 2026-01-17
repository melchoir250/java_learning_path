package hashset;


import java.util.HashSet;

public class HashSetTask1_Print {

    public static void main(String[] args) {
        hashSetPrint();
    }

    public static void hashSetPrint() {
        HashSet<Integer> nums = new HashSet<>();
        nums.add(1);
        nums.add(3);
        nums.add(4);
        nums.add(7);

        System.out.println(nums);
    }
}
