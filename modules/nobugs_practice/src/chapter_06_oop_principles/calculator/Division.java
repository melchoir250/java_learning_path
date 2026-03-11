package chapter_06_oop_principles.calculator;

public class Division implements Operation {

    @Override
    public double apply(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero!");
        }
        return a / b;
    }
}