package switch_task;

public class SimpleCalculator {
    public static void Calculate(int a, int b, String operator) {
        switch (operator) {
            case "+":
                System.out.println(a + b);
                break;

            case "-":
                System.out.println(a - b);
                break;

            case "*":
                System.out.println(a * b);
                break;

            case "/":
                if (b == 0) {
                    System.out.println("На ноль делить нельзя.");
                } else {
                    System.out.println(a / b);
                }
                break;
        }
    }

    public static void main(String[] args) {
        Calculate(12, 4, "+");
        Calculate(13, 2, "-");
        Calculate(12, 0, "/");
    }
}