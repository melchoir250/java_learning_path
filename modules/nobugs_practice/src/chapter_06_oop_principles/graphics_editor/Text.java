package chapter_06_oop_principles.graphics_editor;

public class Text implements Drawable {
    private int x, y;
    private String content;

    public Text(int x, int y, String content) {
        this.x = x;
        this.y = y;
        this.content = content;
    }

    @Override
    public void draw() {
        System.out.println("Текст '" + content +
                "' в позиции (" + x + "," + y + ")");
    }
}