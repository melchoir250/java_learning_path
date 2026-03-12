package hw_13_debugging.task_06_countdown_recursion;

public class DebugTask6 {
    public static void main(String[] args) {
        countdown(5);
    }

    public static void countdown(int n) {
        if (n != 0) {
            System.out.println(n);
            countdown(n - 1);
        }
    }
}