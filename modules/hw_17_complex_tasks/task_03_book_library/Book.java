public class Book {
    private String title;
    private String author;
    private String description;
    private String content;

    public Book(String title, String author, String description, String content) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public String getContent() {
        return content;
    }
}
