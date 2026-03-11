package chapter_06_oop_principles.graphics_editor;

public class Main {
    public static void main(String[] args) {
        Canvas canvas = new Canvas();
        canvas.renderAll();

        Line line = new Line(10, 10, 100, 50);
        Rectangle rect = new Rectangle(20, 30, 80, 60);
        Text text = new Text(50, 70, "Привет, мир!");

        canvas.addElement(line);
        canvas.addElement(rect);
        canvas.renderAll();

        canvas.addElement(text);
        canvas.renderAll();

        canvas.removeElement(line);
        canvas.renderAll();
    }
}