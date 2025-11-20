package circle;

public class Circle {
    int radius;

    Circle(int someRadius) {

        this.radius = someRadius;
    }

    int getRadius() {

        return this.radius;
    }

    void setRadius(int newRadius) {

        this.radius = newRadius;
    }

    void calculateArea() {

        System.out.println("Площадь: " + Math.PI * getRadius() * getRadius());
    }

    void calculateCircumference() {

        System.out.println("Длина окружности: " + 2 * Math.PI * getRadius());
    }
}
