package hw_12_unit_test.task_09_count_words;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class WordCounterTest {
    // Обычная строка: `"Hello world"` → 2
    // Строка с лишними пробелами: `" Java is awesome "` → 3
    // Пустая строка: `""` → 0
    // Строка с пробелами: `" "` → 0
    // `null` → исключение

    private final WordCounter wordCounter = new WordCounter();

    @ParameterizedTest
    @CsvSource({
            "Hello world, 2",
            " Java is awesome , 3",
            "'', 0",
            "' ' , 0"
    })
    public void parametrizeWordCount(String input, int expect) {
        assertEquals(expect, wordCounter.countWords(input));
    }

    @Test
    public void nullWordCount() {
        assertThrows(NullPointerException.class, () -> {
            wordCounter.countWords(null);
        });
    }
}
