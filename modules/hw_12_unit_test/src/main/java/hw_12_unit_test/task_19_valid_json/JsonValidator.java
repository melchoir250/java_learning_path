package hw_12_unit_test.task_19_valid_json;

import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonValidator {
    public boolean isValidJson(String json) {
        try {
            new ObjectMapper().readTree(json);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
