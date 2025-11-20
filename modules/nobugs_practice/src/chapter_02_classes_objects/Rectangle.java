package chapter_02_classes_objects;

public class Rectangle {
    int width;
    int height;

    Rectangle(int someWidth, int someHeight) {
        this.width = someWidth;
        this.height = someHeight;
    }

    int getArea() {
        return this.width * this.height;
    }

    boolean isSquare() {
        return this.width == this.height;
    }
}
