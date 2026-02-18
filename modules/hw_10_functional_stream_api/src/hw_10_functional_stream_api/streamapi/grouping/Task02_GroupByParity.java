package hw_10_functional_stream_api.streamapi.grouping;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task02_GroupByParity {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 3, 5, 7, 4, 3, 6, 7, 9, 12);

        Map<Boolean, List<Integer>> group = numbers.stream()
                .collect(Collectors.groupingBy(n -> n % 2 == 0));
        System.out.println(group);
    }
}
