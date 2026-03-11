package chapter_06_oop_principles.calculator;

public class Subtraction implements Operation {

    @Override
    public double apply(double a, double b) {
        return a - b;
    }
}