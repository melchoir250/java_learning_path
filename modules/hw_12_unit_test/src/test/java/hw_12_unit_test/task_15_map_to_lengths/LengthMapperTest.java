package hw_12_unit_test.task_15_map_to_lengths;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LengthMapperTest {
    // `["Java", "C++", "Go"]` → `[4, 3, 2]`
    // `[]` → `[]`

    private final LengthMapper lengthMapper = new LengthMapper();

    @Test
    public void ListLengthMapper() {
        List<String> words = List.of("Java", "C++", "Go");
        List<Integer> res_words = lengthMapper.mapToLengths(words);
        assertEquals(List.of(4, 3, 2), res_words);
    }

    @Test
    public void ListEmptyLengthMapper() {
        List<String> words = List.of();
        List<Integer> res_words = lengthMapper.mapToLengths(words);
        assertTrue(res_words.isEmpty());
    }
}
