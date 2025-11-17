package math_constant;

public class MathConstants {
    static final double PI = 3.14159;
    static final double E = 2.71828;

    static double calculateCircleArea(double r) {
        return PI * r * r;
    }

    static double calculateCircumference(double r) {
        return 2 * r * PI;
    }

    void print(double r) {
        System.out.println("Radius: " + r);
        System.out.println("Circle Area: " + calculateCircleArea(r));
        System.out.println("Circumference: " + calculateCircumference(r));
    }
}
