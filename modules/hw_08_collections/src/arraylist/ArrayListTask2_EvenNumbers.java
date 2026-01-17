package arraylist;


import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListTask2_EvenNumbers {

    public static void main(String[] args) {
        arrayListEvenNumbers();
    }

    public static void arrayListEvenNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(10, 11, 12, 13, 14, 15));

        for (int i = 0; i < numbers.size(); i++) {
            int number = numbers.get(i);
            if (number % 2 == 0) {
                System.out.println(number);
            }
        }
    }
}
