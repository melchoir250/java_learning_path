package hw_13_debugging.task_08_double_comparison;

public class DebugTask8 {
    public static void main(String[] args) {
        double epsilon = 0.00001;
        double a = 0.1 * 3;
        double b = 0.3;
        if (Math.abs(a - b) < epsilon) {
            System.out.println("Equal");
        } else {
            System.out.println("Not Equal");
        }
    }
}