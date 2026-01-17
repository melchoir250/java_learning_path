package arraylist;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListTask3_LongestString {

    public static void main(String[] args) {
        arrayListLongestString();
    }

    public static void arrayListLongestString() {
        ArrayList<String> long_word = new ArrayList<>(Arrays.asList(
                "java", "python3", "kotlin", "rust", "pascal"));

        String longest = "";

        for (String word : long_word) {
            if (longest.length() < word.length()) {
                longest = word;
            }
        }
        System.out.println(longest);
    }
}
