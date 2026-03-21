package chapter_06_oop_principles.library_info;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Library {
    private final List<Book> allBooks = new ArrayList<>();

    public void addBooks(Book newBooks) {
        allBooks.add(newBooks);
    }

    public List<Book> findByAuthor(String authorName) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : allBooks) {
            if (Objects.equals(book.getAuthor(), authorName)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public List<Book> findByYear(int yearBook) {
        List<Book> foundYearBook = new ArrayList<>();
        for (Book book : allBooks) {
            if (book.getYear() == yearBook) {
                foundYearBook.add(book);
            }
        }
        return foundYearBook;
    }
}
