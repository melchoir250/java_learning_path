package hw_10_functional_stream_api.lambda;

import java.util.function.Function;

public class Task04_FunctionStringLength {
    public static void main(String[] args) {
        Function<String, Integer> stringLength = s -> s.length();

        System.out.println(stringLength.apply("text"));
    }
}
