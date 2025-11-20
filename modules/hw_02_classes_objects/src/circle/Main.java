package circle;

public class Main {
    public static void main(String[] args) {
        Circle circle1 = new Circle(2);
        circle1.calculateArea();
        circle1.calculateCircumference();
        circle1.setRadius(3);
        circle1.calculateArea();
        circle1.calculateCircumference();
    }
}
