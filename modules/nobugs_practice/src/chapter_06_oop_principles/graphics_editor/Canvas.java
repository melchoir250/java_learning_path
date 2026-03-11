package chapter_06_oop_principles.graphics_editor;

import java.util.ArrayList;
import java.util.List;

public class Canvas {
    private List<Drawable> elements = new ArrayList<>();

    public void addElement(Drawable element) {
        elements.add(element);
        System.out.println("Элемент добавлен на холст");
    }

    public void removeElement(Drawable element) {
        elements.remove(element);
        System.out.println("Элемент удалён с холста");
    }

    public void renderAll() {
        System.out.println("\n Отрисовка холста");
        if (elements.isEmpty()) {
            System.out.println("Холст пуст");
        } else {
            for (Drawable element : elements) {
                element.draw();
            }
        }
    }
}