package mock_interviews.task9;

public class Book {
    private final String nameBook;
    private final String authorBook;
    private int countBook;

    public Book(String nameBook, String authorBook, int countBook) {
        this.nameBook = nameBook;
        this.authorBook = authorBook;
        this.countBook = countBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public String getAuthorBook() {
        return authorBook;
    }

    public int getCountBook() {
        return countBook;
    }

    public void setCountBook(int countBook) {
        this.countBook = countBook;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + nameBook + '\'' +
                ", author='" + authorBook + '\'' +
                ", count=" + countBook +
                '}';
    }
}