package hw_10_functional_stream_api.streamapi.aggregate;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Task02_FindMin {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 3, 4, 5, 67, 56, 35, 2, 4, -12, -13);

        Optional<Integer> min = numbers.stream().min(Comparator.naturalOrder());

        System.out.println("Min numbers: " + min.orElse(null));
    }
}
