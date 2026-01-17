package arraylist;


import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListTask4_Sum {

    public static void main(String[] args) {
        arrayListSum();
    }

    public static void arrayListSum() {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        int sum = 0;

        for (int num : numbers) {
            sum += num;
        }
        System.out.println(sum);
    }
}
