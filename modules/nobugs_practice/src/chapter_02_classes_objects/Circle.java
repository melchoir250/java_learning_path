package chapter_02_classes_objects;

public class Circle {
    double radius;

    Circle(double setRadius) {
        this.radius = setRadius;
    }

    double getArea() {
        return Math.PI * this.radius * this.radius;
    }
}
