package hw_12_unit_test.task_02_count_vowels;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class VowelCounterTest {
    // hello -> 2
    // abaa -> 3
    // AETUWO -> 4
    // "" -> 0
    // glhdsv -> 0
    // null -> IllegalArgumentException

    private final VowelCounter vowelCounter = new VowelCounter();

    @ParameterizedTest
    @CsvSource({"hello, 2", "abaa, 3", "AETUWO, 4", "'', 0", "glhdsv, 0"})
    public void trueVowelsCount(String input, int expect) {
        assertEquals(expect, vowelCounter.countVowels(input));
    }

    @Test
    public void nullVowelsCount() {
        assertThrows(IllegalArgumentException.class, () -> {
            vowelCounter.countVowels(null);
        });
    }
}
