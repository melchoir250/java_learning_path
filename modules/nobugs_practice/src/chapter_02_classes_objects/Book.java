package chapter_02_classes_objects;

public class Book {
    String title;
    String author;

    Book(String someTitle, String someAuthor) {
        this.title = someTitle;
        this.author = someAuthor;
    }

    void printInfo() {
        System.out.println("Title: " + this.title + ", Author: " + this.author);
    }
}
