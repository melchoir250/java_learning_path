package chapter_04_conditions_loops;

public class StopwatchWithPause {
    public static void main(String[] args) {
        stopwatchWithPause();
    }

    public static void stopwatchWithPause() {
        for (int i = 0; i <= 10; i++) {
            if (i == 5) {
                System.out.println("Пауза");
            }
            System.out.println(i);
        }
    }
}
