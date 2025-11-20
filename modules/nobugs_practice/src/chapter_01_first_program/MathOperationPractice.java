package chapter_01_first_program;

public class MathOperationPractice {
    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static double divide(int a, int b) {
        if (b == 0) {
            System.out.println("Ошибка: деление на ноль");
            return Double.NaN;
        } else {
            return (double) a / b;
        }
    }

    public static int findMax(int a, int b) {
        return Math.max(a, b);
    }

    public static int findMin(int a, int b) {
        return Math.min(a, b);
    }

    public static int modules(int a, int b) {
        return a % b;
    }

    public static int average(int a, int b) {
        return (a + b) / 2;
    }

    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    public static boolean isOdd(int n) {
        return n % 2 != 0;
    }

    public static int square(int x) {
        return x * x;
    }

    public static int cube(int x) {
        return x * x * x;
    }

    public static double squareRoot(double x) {
        return Math.sqrt(x);
    }

    public static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public static double roundUp(double x) {
        return Math.ceil(x);
    }

    public static double roundDown(double x) {
        return Math.floor(x);
    }

    public static long roundNearest(double x) {
        return Math.round(x);
    }

    public static int absolute(int x) {
        return Math.abs(x);
    }

    public static void swap(int a, int b) {
        System.out.println(a);
        System.out.println(b);

        int temp = a;
        a = b;
        b = temp;
        System.out.println(a);
        System.out.println(b);
    }

    public static int minutesToHours(int minutes) {
        return minutes / 60;
    }

    public static int secondsToMinutes(int seconds) {
        return seconds / 60;
    }

    public static double celsiusToFahrenheit(double c) {
        return c * 9 / 5 + 32;
    }

    public static double kmToMiles(double km) {
        return km * 0.621371;
    }

    public static boolean isDivisible(int a, int b) {
        if (b == 0) {
            System.out.println("Ошибка: деление на ноль");
        }
        return a % b == 0;
    }

    public static void print(String comment, Object method) {
        System.out.println(comment + method);
    }

    public static void main(String[] args) {
        print("add: ", add(1, 2));
        print("subtract: ", subtract(1, 2));
        print("multiply: ", multiply(1, 2));
        print("divide: ", divide(3, 2));
        print("divide: ", divide(3, 0));
        print("findMax: ", findMax(3, 5));
        print("findMin: ", findMin(3, 5));
        print("modules: ", modules(13, 6));
        print("average: ", average(13, 6));
        print("isEven: ", isEven(13));
        print("isOdd: ", isOdd(13));
        print("square: ", square(3));
        print("cube: ", cube(3));
        print("squareRoot: ", squareRoot(12));
        print("power: ", power(2, 3));
        print("roundUp: ", roundUp(12.3));
        print("roundDown: ", roundDown(12.3));
        print("roundNearest: ", roundNearest(15.7));
        print("absolute: ", absolute(-22));
        swap(12, 15);
        print("minutesToHours: ", minutesToHours(340));
        print("secondsToMinutes: ", secondsToMinutes(3500));
        print("celsiusToFahrenheit: ", celsiusToFahrenheit(30));
        print("kmToMiles: ", kmToMiles(500));
        print("isDivisible: ", isDivisible(10, 2));
        print("isDivisible: ", isDivisible(9, 2));
    }
}
