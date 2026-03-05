package hw_12_unit_test.task_11_filter_even_list;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EvenListFilterTest {
    // `[1, 2, 3, 4, 5, 6]` → `[2, 4, 6]`
    // `[1, 3, 5]` → `[]`
    // `[]` → `[]`

    private final EvenListFilter evenListFilter = new EvenListFilter();

    @Test
    public void returnEvenListFilter() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> result = evenListFilter.filterEvenNumbers(numbers);
        assertEquals(List.of(2, 4, 6), result);
    }

    @Test
    public void returnEmptyListFilter() {
        List<Integer> numbers = List.of(1, 3, 5, 7);
        List<Integer> result = evenListFilter.filterEvenNumbers(numbers);
        assertTrue(result.isEmpty());
    }

    @Test
    public void returnListFilter() {
        List<Integer> numbers = List.of();
        List<Integer> result = evenListFilter.filterEvenNumbers(numbers);
        assertTrue(result.isEmpty());
    }
}
