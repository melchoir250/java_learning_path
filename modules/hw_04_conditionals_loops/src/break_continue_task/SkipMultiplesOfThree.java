package break_continue_task;

public class SkipMultiplesOfThree {
    public static void SkipMultiply() {
        for (int i = 1; i <= 20; i++) {
            if (i % 3 == 0) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        SkipMultiply();
    }
}
