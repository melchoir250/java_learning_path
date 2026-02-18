package hw_10_functional_stream_api.streamapi.basic;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task02_FilterMultiplesOf5 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 5, 7, 12, 15, 17, 33, 35, 45, 44);

        List<Integer> multiplyNumber = numbers.stream()
                .filter(n -> n % 5 == 0)
                .collect(Collectors.toList());

        System.out.println("Исходный: " + numbers);
        System.out.println("Кратный: " + multiplyNumber);
    }
}
