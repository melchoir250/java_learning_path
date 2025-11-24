package switch_task;

public class SimpleCalculator {
    public static void Calculate(int a, int b, String operator) {
        if (b == 0) {
            System.out.println("На ноль делить нельзя");
        } else {
            if (operator == "+") {
                System.out.println(a + b);
            } else if (operator == "-") {
                System.out.println(a - b);
            } else if (operator == "*") {
                System.out.println(a * b);
            } else if (operator == "/") {
                System.out.println(a / b);
            }
        }
    }

    public static void main(String[] args) {
        Calculate(12, 4, "+");
        Calculate(13, 2, "-");
        Calculate(12, 0, "/");
    }
}