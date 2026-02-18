package hw_10_functional_stream_api.lambda;


import java.util.function.Predicate;

public class Task03_PredicateEven {
    public static void main(String[] args) {
        Predicate<Integer> isEven = x -> x % 2 == 0;

        System.out.println(isEven.test(10));
        System.out.println(isEven.test(7));
    }
}
