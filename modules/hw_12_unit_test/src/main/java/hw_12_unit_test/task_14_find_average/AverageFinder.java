package hw_12_unit_test.task_14_find_average;

import java.util.Arrays;

public class AverageFinder {
    public double findAverage(int[] numbers) {
        return Arrays.stream(numbers).average().orElseThrow();
    }
}
