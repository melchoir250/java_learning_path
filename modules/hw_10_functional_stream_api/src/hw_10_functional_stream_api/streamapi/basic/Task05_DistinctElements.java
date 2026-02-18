package hw_10_functional_stream_api.streamapi.basic;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task05_DistinctElements {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 5, 4, 4, 12, 12);

        List<Integer> uniqueNumber = numbers.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Исходный: " + numbers);
        System.out.println("Полученный: " + uniqueNumber);
    }
}
