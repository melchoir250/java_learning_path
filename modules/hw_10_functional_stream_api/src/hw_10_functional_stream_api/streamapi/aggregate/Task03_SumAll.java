package hw_10_functional_stream_api.streamapi.aggregate;


import java.util.Arrays;
import java.util.List;

public class Task03_SumAll {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(5, 10, 15, 20);

        int sum = numbers.stream().mapToInt(n -> n).sum();

        System.out.println("Sum = " + sum);
    }
}
