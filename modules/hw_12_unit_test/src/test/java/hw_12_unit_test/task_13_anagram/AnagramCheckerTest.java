package hw_12_unit_test.task_13_anagram;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class AnagramCheckerTest {
    // `"listen", "silent"` → `true`
    // `"java", "python"` → `false`
    // null, word → false

    private final AnagramChecker anagramChecker = new AnagramChecker();

    @ParameterizedTest
    @CsvSource({
            "listen, silent, true",
            "java, python, false",
            "Triangle, Integral, true",
            "'Dormitory', 'Dirty room', true"
    })
    public void anagramCheckerParametrize(String word1, String word2, boolean expect) {
        assertEquals(expect, anagramChecker.isAnagram(word1, word2));
    }

    @Test
    public void anagramCheckerNull() {
        assertFalse(anagramChecker.isAnagram(null, "word"));
    }

    @Test
    public void anagramCheckerSecondWordNull() {
        assertFalse(anagramChecker.isAnagram("word", null));
    }

    @Test
    public void anagramCheckerBothNull() {
        assertFalse(anagramChecker.isAnagram(null, null));
    }
}
