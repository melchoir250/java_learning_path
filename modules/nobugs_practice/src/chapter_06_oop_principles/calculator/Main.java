package chapter_06_oop_principles.calculator;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(new Addition());

        System.out.println("Сложение: " + calculator.calculate(10, 5)); // 15.0

        calculator.setOperation(new Subtraction());
        System.out.println("Вычитание: " + calculator.calculate(10, 5)); // 5.0

        calculator.setOperation(new Multiplication());
        System.out.println("Умножение: " + calculator.calculate(10, 5)); // 50.0

        calculator.setOperation(new Division());
        System.out.println("Деление: " + calculator.calculate(10, 5)); // 2.0
    }
}