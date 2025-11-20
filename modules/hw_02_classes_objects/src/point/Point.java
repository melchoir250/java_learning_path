package point;

public class Point {
    int x;
    int y;

    Point(int someX, int someY) {
        this.x = someX;
        this.y = someY;
    }

    int getX() {

        return this.x;
    }

    void setX(int newX) {

        this.x = newX;
    }

    void print() {

        System.out.println("Координаты X: " + getX() + ", Координаты Y: " + this.y);
    }
}
