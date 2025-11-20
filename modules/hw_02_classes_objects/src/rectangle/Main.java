package rectangle;


public class Main {
    public static void main(String[] args) {
        Rectangle area1 = new Rectangle(4, 3);
        area1.calculateArea();
        area1.setWidth(5);
        area1.calculateArea();

        Rectangle area2 = new Rectangle(7, 8);
        area2.calculateArea();
        area2.setWidth(4);
        area2.calculateArea();
    }
}
