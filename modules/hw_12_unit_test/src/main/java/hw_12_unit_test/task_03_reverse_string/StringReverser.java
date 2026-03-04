package hw_12_unit_test.task_03_reverse_string;

public class StringReverser {
    public String reverse(String input) {
        if (input == null) return null;
        return new StringBuilder(input).reverse().toString();
    }
}
