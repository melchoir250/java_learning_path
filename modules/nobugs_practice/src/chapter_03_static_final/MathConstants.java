package chapter_03_static_final;

public class MathConstants {
    final static double PI = 3.14159;
    final static double E = 2.71828;

    public static void print() {
        System.out.println("PI: " + PI + ", E: " + E);
    }

    public static void main(String[] args) {
        print();
    }
}
