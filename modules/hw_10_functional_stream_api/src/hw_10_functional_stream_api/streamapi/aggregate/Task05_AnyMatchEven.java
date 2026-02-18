package hw_10_functional_stream_api.streamapi.aggregate;


import java.util.Arrays;
import java.util.List;

public class Task05_AnyMatchEven {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 3, 54, 5, 7, 8, 9, 4, 45);

        boolean hasEven = numbers.stream().anyMatch(n -> n % 2 == 0);

        System.out.println(hasEven);
    }
}
