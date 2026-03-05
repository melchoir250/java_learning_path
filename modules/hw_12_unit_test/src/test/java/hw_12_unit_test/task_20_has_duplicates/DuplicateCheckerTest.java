package hw_12_unit_test.task_20_has_duplicates;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DuplicateCheckerTest {
    // `[1, 2, 3, 4, 5]` → false
    // `[1, 2, 2, 3]` → true
    // `[]` → false

    private final DuplicateChecker duplicateChecker = new DuplicateChecker();

    @Test
    public void noDuplicateChecker() {
        int[] numbers = {1, 2, 3, 4, 5};
        assertFalse(duplicateChecker.hasDuplicates(numbers));
    }

    @Test
    public void trueDuplicateChecker() {
        int[] numbers = {1, 2, 2, 3};
        assertTrue(duplicateChecker.hasDuplicates(numbers));
    }

    @Test
    public void emptyDuplicateChecker() {
        int[] numbers = {};
        assertFalse(duplicateChecker.hasDuplicates(numbers));
    }
}
