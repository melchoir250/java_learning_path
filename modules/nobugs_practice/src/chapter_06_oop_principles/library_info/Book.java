package chapter_06_oop_principles.library_info;


class Book {
    private final String book;
    private final String author;
    private final int year;

    public Book(String book, String author, int year) {
        this.book = book;
        this.author = author;
        this.year = year;
    }

    public String getBook() {
        return book;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }
}