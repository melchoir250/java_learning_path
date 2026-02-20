package hw_10_functional_stream_api.funcinterfaces;


public class Task01_MathOperationDemo {
    public static void main(String[] args) {

        MathOperation addition = (a, b) -> a + b;
        MathOperation subtraction = (a, b) -> a - b;
        MathOperation multiplication = (a, b) -> a * b;
        MathOperation division = (a, b) -> {
            if (b == 0) {
                throw new ArithmeticException("На ноль делить нельзя");
            }
            return a / b;
        };

        double x = 10;
        double y = 0;

        System.out.println("addition: " + addition.operate(x, y));
        System.out.println("subtraction: " + subtraction.operate(x, y));
        System.out.println("multiplication: " + multiplication.operate(x, y));
        try {
            System.out.println("division: " + division.operate(x, y));
        } catch (ArithmeticException e) {
            System.out.println("division: ошибка - " + e.getMessage());
        }
    }
}
