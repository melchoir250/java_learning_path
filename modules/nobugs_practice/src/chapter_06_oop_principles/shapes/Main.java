package chapter_06_oop_principles.shapes;

public class Main {
    static void printArea(Shape s) {
        System.out.println("Area: " + s.getArea());
    }

    public static void main(String[] args) {

        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);
        Shape triangle = new Triangle(3, 7);

        printArea(circle);
        printArea(rectangle);
        printArea(triangle);
    }
}
