package hw_12_unit_test.task_19_valid_json;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class JsonValidatorTest {
    // `"{\"key\":\"value\"}"` → true
    // `"invalid json"` → false
    // `null` → false

    private final JsonValidator jsonValidator = new JsonValidator();

    @ParameterizedTest
    @CsvSource({
            "'{\"key\":\"value\"}', true",
            "'invalid json', false",
    })
    public void parametrizedJsonValidator(String json, boolean expected) {
        assertEquals(expected, jsonValidator.isValidJson(json));
    }

    @Test
    public void nullJsonValidator() {
        assertFalse(jsonValidator.isValidJson(null));
    }
}
