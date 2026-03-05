package hw_12_unit_test.task_15_map_to_lengths;

import java.util.List;
import java.util.stream.Collectors;

public class LengthMapper {
    public List<Integer> mapToLengths(List<String> words) {
        return words.stream().map(String::length).collect(Collectors.toList());
    }
}
