package hw_12_unit_test.task_04_find_max;

import java.util.Arrays;

public class MaxFinder {
    public int findMax(int[] numbers) {
        return Arrays.stream(numbers).max().orElseThrow();
    }
}
