package hw_10_functional_stream_api.streamapi.basic;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task03_MapStringsToLengths {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Java", "Python", "Go", "Rust");

        List<Integer> length = words.stream()
                .map(s -> s.length())
                .collect(Collectors.toList());

        System.out.println("Исходный: " + words);
        System.out.println("Полученный: " + length);
    }
}
