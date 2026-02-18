package hw_10_functional_stream_api.lambda;

import java.util.function.Consumer;

public class Task05_ConsumerPrint {
    public static void main(String[] args) {
        Consumer<String> stringConsumer = s -> System.out.println(s);
        stringConsumer.accept("Привет");
    }
}
