package chapter_06_oop_principles.graphics_editor;

public class Rectangle implements Drawable {
    private int x, y, width, height;

    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("Прямоугольник в (" + x + "," + y +
                ") размером " + width + " x " + height);
    }
}