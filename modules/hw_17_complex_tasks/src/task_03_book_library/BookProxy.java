package task_03_book_library;

public class BookProxy {
    private final Book book;
    private String content;
    private boolean isLoaded = false;

    public BookProxy(Book book) {
        this.book = book;
    }

    public String getContent() {
        if (!isLoaded) {
            content = loadContent();
            isLoaded = true;
        }
        return content;
    }

    private String loadContent() {
        System.out.println("Loading content for book: " + book.getTitle());
        return "Chapter 1. It was the best of times.";
    }
}
