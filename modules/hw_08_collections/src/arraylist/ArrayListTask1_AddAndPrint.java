package arraylist;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListTask1_AddAndPrint {
    public static void main(String[] args) {
        arrayListAddAndPrint();
    }

    public static void arrayListAddAndPrint() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        numbers.add(5);
        System.out.println(numbers);
    }
}
