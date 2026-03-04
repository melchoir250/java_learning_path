package hw_12_unit_test.task_09_count_words;

public class WordCounter {
    public int countWords(String sentence) {
        return sentence.trim().isEmpty() ? 0 : sentence.split("\\s+").length;
    }
}
