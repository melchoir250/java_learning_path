package hw_12_unit_test.task_12_sort_by_length;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LengthSorterTest {
    // `["Java", "C", "Python"]` → `["C", "Java", "Python"]`
    // `["aa", "bb", "cc"]` → `["aa", "bb", "cc"]`
    // `[]` → `[]`

    private final LengthSorter lengthSorter = new LengthSorter();

    @Test
    public void lengthSorterWordsLanguageProgram() {
        List<String> words = List.of("Java", "C", "Python");
        List<String> res = lengthSorter.sortByLength(words);
        assertEquals(List.of("C", "Java", "Python"), res);
    }

    @Test
    public void lengthSortedWordsSome() {
        List<String> words = List.of("aa", "bb", "cc");
        List<String> result = lengthSorter.sortByLength(words);
        assertEquals(List.of("aa", "bb", "cc"), result);
    }

    @Test
    public void lengthSortedWordsEmptyList() {
        List<String> words = List.of();
        List<String> res = lengthSorter.sortByLength(words);
        assertTrue(res.isEmpty());
    }
}
