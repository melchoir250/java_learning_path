package hw_12_unit_test.task_11_filter_even_list;

import java.util.List;
import java.util.stream.Collectors;

public class EvenListFilter {
    public List<Integer> filterEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
    }
}
