package hw_10_functional_stream_api.streamapi.aggregate;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Task01_FindMax {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 3, 4, 5, 67, 56, 35, 2, 4);

        Optional<Integer> max = numbers.stream().max(Comparator.naturalOrder());

        System.out.println("Max number: " + max.orElse(null));
    }
}
