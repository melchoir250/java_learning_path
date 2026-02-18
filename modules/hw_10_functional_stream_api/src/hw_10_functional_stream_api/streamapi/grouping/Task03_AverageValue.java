package hw_10_functional_stream_api.streamapi.grouping;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task03_AverageValue {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 3, 5, 7, 4, 3, 6, 7, 9, 12);

        double average = numbers.stream()
                .collect(Collectors.averagingInt(n -> n));
        System.out.println(average);
    }
}
