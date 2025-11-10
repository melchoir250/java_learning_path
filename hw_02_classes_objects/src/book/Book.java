package book;

public class Book {
    String title;
    String author;

    Book(String someTtile, String someAuthor) {
        this.author = someAuthor;
        this.title = someTtile;
    }

    String getTitle() {

        return this.title;
    }

    String getAuthor() {

        return this.author;
    }

    void setTitle(String newTitle) {

        this.title = newTitle;
    }

    void setAuthor(String newAuthor) {

        this.author = newAuthor;
    }

    void printInfo() {

        System.out.println("Название книги: " + getTitle() + ", Автор: " + getAuthor());
    }
}
