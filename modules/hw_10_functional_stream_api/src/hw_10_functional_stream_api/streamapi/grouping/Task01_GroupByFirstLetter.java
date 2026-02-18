package hw_10_functional_stream_api.streamapi.grouping;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task01_GroupByFirstLetter {
    public static void main(String[] args) {

        List<String> words = Arrays.asList("Арбуз", "Банан", "Киви", "Груша", "Брусника");

        Map<Character, List<String>> group = words.stream()
                .collect(Collectors.groupingBy(s -> s.charAt(0)));
        System.out.println(group);
    }
}
