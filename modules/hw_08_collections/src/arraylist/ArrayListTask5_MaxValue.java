package arraylist;


import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListTask5_MaxValue {

    public static void main(String[] args) {
        arrayListMaxValue();
    }

    public static void arrayListMaxValue() {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(10, 22, 14, 77, 68, 9));

        int max_number = 0;

        for (int num : numbers) {
            if (max_number < num) {
                max_number = num;
            }
        }
        System.out.println(max_number);
    }
}
