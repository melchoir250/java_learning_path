package chapter_02_classes_objects;

public class Pen {
    String color;

    Pen(String someColor) {
        this.color = someColor;
    }

    void write(String text) {
        System.out.println(this.color + " ручка пишет: " + text);
    }

    public static void main(String[] args) {
        Pen pen_color1 = new Pen("Красный");
        pen_color1.write("Петушок");

        Pen pen_color2 = new Pen("Синий");
        pen_color2.write("Машина");
    }
}
