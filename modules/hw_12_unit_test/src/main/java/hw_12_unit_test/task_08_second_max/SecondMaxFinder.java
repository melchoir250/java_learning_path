package hw_12_unit_test.task_08_second_max;

import java.util.Arrays;

public class SecondMaxFinder {
    public int findSecondMax(int[] numbers) {
        return Arrays.stream(numbers).distinct().sorted()
                .skip(numbers.length - 2).findFirst().orElseThrow();
    }
}
