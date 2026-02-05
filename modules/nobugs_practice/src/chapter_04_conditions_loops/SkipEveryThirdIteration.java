package chapter_04_conditions_loops;

import java.util.ArrayList;
import java.util.List;

public class SkipEveryThirdIteration {
    public static void main(String[] args) {
        skipEveryThird();
    }

    public static void skipEveryThird() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            numbers.add(i);
        }


        for (int number : numbers) {
            if (number % 3 == 0) {
                continue;
            }
            System.out.println(number);
        }
    }
}
