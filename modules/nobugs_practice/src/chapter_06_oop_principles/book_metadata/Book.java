package chapter_06_oop_principles.book_metadata;

public class Book {
    private final String title;
    private final String author;
    private final String isbn;
    private final int year;
    private final String publisher;
    private final int pagesCount;

    public Book(String title, String author, String isbn, int year, String publisher, int pagesCount) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.year = year;
        this.publisher = publisher;
        this.pagesCount = pagesCount;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getYear() {
        return year;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getPagesCount() {
        return pagesCount;
    }
}