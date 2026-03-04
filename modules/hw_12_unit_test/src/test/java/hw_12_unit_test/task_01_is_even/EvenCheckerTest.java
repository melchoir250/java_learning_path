package hw_12_unit_test.task_01_is_even;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class EvenCheckerTest {
    // четные числа 2, 4, 100 -> true
    // нечетные числа 1, 3, 99 -> false
    // нулевое значение 0 -> true
    // отрицательные четные числа -2, -4 -> true
    // отрицательные нечетные числа -1, -3 -> false

    private final EvenChecker EvenChecker = new EvenChecker();

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 100, 0, -2, -4})
    public void evenNumbersChecker(int number) {
        assertTrue(EvenChecker.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 99, -1, -3})
    public void notEvenNumbersChecker(int number) {
        assertFalse(EvenChecker.isEven(number));
    }
}
