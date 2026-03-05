package hw_12_unit_test.task_18_gcd;

public class GcdCalculator {
    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
