package chapter_06_oop_principles.document_editor;

public class Main {
    public static void main(String[] args) {
        Document document = new Document();
        document.appendText("Java ");
        document.appendText("is ");
        document.appendText("awesome");
        System.out.println("Текущий текст: " + document);
        document.undo();
        System.out.println("Текущий текст: " + document);
        document.undo();
        System.out.println("Текущий текст: " + document);
        document.undo();
        System.out.println("Текущий текст: " + document);
    }
}