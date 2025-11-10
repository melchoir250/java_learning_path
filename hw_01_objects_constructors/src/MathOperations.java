public class MathOperations {

    public static int add(int x, int y) {
        return x + y;
    }

    public static int subtract(int x, int y) {
        return x - y;
    }

    public static int multiply(int x, int y) {
        return x * y;
    }

    public static double divide(int x, int y) {
        return (double) x / y;
    }

    public static int findMax(int a, int b) {
        return Math.max(a, b);
    }

    public static int difference(int x, int y) {
        return Math.abs(x - y);
    }

    public static int squareArea(int side) {
        return side * side;
    }

    public static int squarePerimeter(int side) {
        return 4 * side;
    }

    public static double convertSecondsToMinutes(int seconds) {
        return (double) seconds / 60;
    }

    public static double averageSpeed(double distance, double time) {
        return distance / time;
    }

    public static double findHypotenuse(double a, double b) {
        return (a * a + b * b);
    }

    public static double circleCircumference(double radius) {
        return 2 * Math.PI * radius;
    }

    public static double calculatePercentage(double total, double part) {
        return (part / total) * 100;
    }

    public static double celsiusToFahrenheit(double c) {
        return c * 9 / 5 + 32;
    }

    public static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    public static void printResult(String description, Object result) {
        System.out.println(description + result);
    }

    public static void main(String[] args) {
        printResult("Сумма чисел: ", add(5, 7));
        printResult("Разница чисел: ", subtract(10, 3));
        printResult("Произведение чисел: ", multiply(5, 4));
        printResult("Деление чисел: ", divide(10, 3));
        printResult("Выводим наибольшее целочисленное число: ", findMax(33, 44));
        printResult("Вывод разницы между двумя числами: ", difference(55, 33));
        printResult("Возвращаем площадь квадрата: ", squareArea(4));
        printResult("Возвращаем периметр квадрата: ", squarePerimeter(5));
        printResult("Возвращаем значение перевода секунд в минуты: ", convertSecondsToMinutes(456));
        printResult("Возвращаем среднюю скорость: ", averageSpeed(600, 60));
        printResult("Возвращаем гипотенузу 1: ", findHypotenuse(12, 2));
        printResult("Возвращаем гипотенузу 2: ", findHypotenuse(14, 3));
        printResult("Возвращаем длину окружности: ", circleCircumference(22));
        printResult("Возвращаем проценты: ", calculatePercentage(22, 5));
        printResult("Возвращаем Фаренгейты: ", celsiusToFahrenheit(500));
        printResult("Возвращаем Цельсии: ", fahrenheitToCelsius(300));
    }
}