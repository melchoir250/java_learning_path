package hw_12_unit_test.task_07_factorial;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class FactorialCalculatorTest {
    // Базовый случай: `factorial(0)` → 1
    // Обычные числа: `factorial(1)` → 1, `factorial(5)` → 120, `factorial(7)` → 5040
    // Отрицательные числа: `factorial(-3)` → IllegalArgumentException

    private final FactorialCalculator factorialCalculator = new FactorialCalculator();

    @ParameterizedTest
    @CsvSource({
            "0, 1",
            "1, 1",
            "5,120",
            "7, 5040"
    })
    public void FactorialCalculator(int input, int expect) {
        assertEquals(expect, factorialCalculator.factorial(input));
    }

    @Test
    public void ExceptFactorialCalculator() {
        assertThrows(IllegalArgumentException.class, () -> {
            factorialCalculator.factorial(-3);
        });
    }
}
