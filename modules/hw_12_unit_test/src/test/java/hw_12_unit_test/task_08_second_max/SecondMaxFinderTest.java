package hw_12_unit_test.task_08_second_max;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class SecondMaxFinderTest {
    // Обычный массив: `[3, 5, 7, 2]` → 5
    // Массив с одинаковыми числами: `[4, 4, 4, 4]` → исключение
    // Один элемент: `[8]` → исключение
    // Пустой массив: `[]` → исключение

    private final SecondMaxFinder secondMaxFinder = new SecondMaxFinder();

    @Test
    public void SecondMaxFinderNormalArray() {
        int[] number = {3, 5, 7, 2};
        assertEquals(5, secondMaxFinder.findSecondMax(number));
    }

    @Test
    public void SecondMaxFinderArrayRepeatNumber() {
        int[] number = {4, 4, 4, 4};
        assertThrows(NoSuchElementException.class, () -> {
            secondMaxFinder.findSecondMax(number);
        });
    }

    @Test
    public void SecondMaxFinderArrayOneElementNumber() {
        int[] number = {8};
        assertThrows(IllegalArgumentException.class, () -> {
            secondMaxFinder.findSecondMax(number);
        });
    }

    @Test
    public void SecondMaxFinderArrayZeroElementNumber() {
        int[] number = {};
        assertThrows(IllegalArgumentException.class, () -> {
            secondMaxFinder.findSecondMax(number);
        });
    }
}
