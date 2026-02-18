package hw_10_functional_stream_api.streamapi.basic;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task04_MapSquares {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 3, 5, 7, 13, 22, 23);

        List<Integer> squares = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());

        System.out.println("Исходный: " + numbers);
        System.out.println("Полученный: " + squares);
    }
}
