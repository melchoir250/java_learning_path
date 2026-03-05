package hw_12_unit_test.task_12_sort_by_length;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LengthSorter {
    public List<String> sortByLength(List<String> words) {
        return words.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}
