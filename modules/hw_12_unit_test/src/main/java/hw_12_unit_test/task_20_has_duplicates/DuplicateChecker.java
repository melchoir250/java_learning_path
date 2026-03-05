package hw_12_unit_test.task_20_has_duplicates;

import java.util.Arrays;

public class DuplicateChecker {
    public boolean hasDuplicates(int[] numbers) {
        return Arrays.stream(numbers).distinct().count() != numbers.length;
    }
}
