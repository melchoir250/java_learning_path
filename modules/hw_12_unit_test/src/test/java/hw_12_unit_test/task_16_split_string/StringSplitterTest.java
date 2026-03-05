package hw_12_unit_test.task_16_split_string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringSplitterTest {
    // `"Java,Python,C++", ","` → `["Java", "Python", "C++"]`
    // `"", ","` → `[""]`
    // `"word", ","` → `["word"]`

    private final StringSplitter stringSplitter = new StringSplitter();

    @Test
    public void SplitString() {
        String[] res = stringSplitter.splitString("Java,Python,C++", ",");

        assertArrayEquals(new String[]{"Java", "Python", "C++"}, res);
    }

    @Test
    public void SplitStringEmpty() {
        String[] res = stringSplitter.splitString("", ",");

        assertArrayEquals(new String[]{""}, res);
    }

    @Test
    public void SplitStringOneWord() {
        String[] res = stringSplitter.splitString("word", ",");

        assertArrayEquals(new String[]{"word"}, res);
    }
}
