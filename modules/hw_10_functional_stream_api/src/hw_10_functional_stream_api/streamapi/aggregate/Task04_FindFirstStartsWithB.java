package hw_10_functional_stream_api.streamapi.aggregate;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Task04_FindFirstStartsWithB {
    public static void main(String[] args) {

        List<String> words = Arrays.asList("Арбуз", "Банан", "Киви", "Груша", "Брусника");

        Optional<String> result = words.stream().filter(s -> s.startsWith("Б")).findFirst();

        System.out.println(result.orElse("Not found"));
    }
}
