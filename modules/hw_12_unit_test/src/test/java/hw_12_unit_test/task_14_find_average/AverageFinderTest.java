package hw_12_unit_test.task_14_find_average;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class AverageFinderTest {
    // `[1, 2, 3, 4, 5]` → 3.0
    // `[10]` → 10.0
    // `[]` → исключение

    private final AverageFinder averageFinder = new AverageFinder();

    @Test
    public void AverageFinderNumbers() {
        int[] numbers = {1, 2, 3, 4, 5};
        double res = averageFinder.findAverage(numbers);
        assertEquals(3.0, res);
    }

    @Test
    public void AverageFinderNumber() {
        int[] numbers = {10};
        double res = averageFinder.findAverage(numbers);
        assertEquals(10.0, res);
    }

    @Test
    public void AverageFinderExcept() {
        int[] num = {};
        assertThrows(NoSuchElementException.class, () -> averageFinder.findAverage(num));
    }
}
