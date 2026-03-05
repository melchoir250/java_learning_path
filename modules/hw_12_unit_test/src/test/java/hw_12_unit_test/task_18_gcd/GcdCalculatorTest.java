package hw_12_unit_test.task_18_gcd;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class GcdCalculatorTest {
    // 24, 36 → 12
    // 101, 103 → 1
    // 0, 10 → 10

    private final GcdCalculator gcdCalculator = new GcdCalculator();

    @ParameterizedTest
    @CsvSource({
            "24, 36, 12",
            "101, 103, 1",
            "0, 10, 10",
    })
    public void GcdCalculator(int num1, int num2, int expected) {
        assertEquals(expected, gcdCalculator.gcd(num1, num2));
    }
}
