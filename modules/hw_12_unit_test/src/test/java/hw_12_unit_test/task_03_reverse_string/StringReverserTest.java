package hw_12_unit_test.task_03_reverse_string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class StringReverserTest {
    // "hello" -> "olleh"
    // "Python" -> "nohtyP"
    // "" -> ""
    // "a" -> "a"
    // null -> null
    // "12345" -> "54321"

    private final StringReverser stringReverser = new StringReverser();

    public static Stream<Arguments> validArguments() {
        return Stream.of(
                Arguments.of("hello", "olleh"),
                Arguments.of("Python", "nohtyP"),
                Arguments.of("", ""),
                Arguments.of("a", "a"),
                Arguments.of(null, null),
                Arguments.of("12345", "54321")
        );
    }

    @ParameterizedTest
    @MethodSource("validArguments")
    public void neStringReverser(String initString, String expectString) {
        assertEquals(expectString, stringReverser.reverse(initString));
    }
}
