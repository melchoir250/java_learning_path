package hw_12_unit_test.task_04_find_max;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class MaxFinderTest {
    // [3, 5, 7, 2] -> 7
    // [1] -> 1
    // [-3, -5, -2, -7] -> -2
    // [] -> NoSuchElementException
    // null -> IllegalArgumentException

    private final MaxFinder maxFinder = new MaxFinder();

    public static Stream<Arguments> Arrays() {
        return Stream.of(
                Arguments.of(new int[]{3, 5, 7, 2}, 7),
                Arguments.of(new int[]{1}, 1),
                Arguments.of(new int[]{-3, -5, -2, -7}, -2)
        );
    }

    @ParameterizedTest
    @MethodSource("Arrays")
    public void maxFindCorrectlyNum(int[] input, int expected) {
        assertEquals(expected, maxFinder.findMax(input));
    }

    @Test
    public void noSuchElementExceptionFindNum() {
        assertThrows(NoSuchElementException.class, () -> {
            maxFinder.findMax(new int[]{});
        });
    }


    @Test
    public void illegalArgumentExceptionFindNum() {
        assertThrows(NullPointerException.class, () -> {
            maxFinder.findMax(null);
        });
    }
}
