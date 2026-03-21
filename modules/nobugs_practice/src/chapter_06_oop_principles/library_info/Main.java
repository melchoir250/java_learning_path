package chapter_06_oop_principles.library_info;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        List<Book> books = List.of(
                new Book("Война и мир", "Лев Толстой", 1869),
                new Book("Анна Каренина", "Лев Толстой", 1877),
                new Book("Преступление и наказание", "Фёдор Достоевский", 1866),
                new Book("Идиот", "Фёдор Достоевский", 1869),
                new Book("Мёртвые души", "Николай Гоголь", 1842),
                new Book("Ревизор", "Николай Гоголь", 1836),
                new Book("Капитанская дочка", "Александр Пушкин", 1836),
                new Book("Евгений Онегин", "Александр Пушкин", 1833),
                new Book("Герой нашего времени", "Михаил Лермонтов", 1840),
                new Book("Белые ночи", "Фёдор Достоевский", 1848)
        );
        for (Book book : books) {
            library.addBooks(book);
        }
        List<Book> bookTolstoy = library.findByAuthor("Лев Толстой");
        for (Book book : bookTolstoy) {
            System.out.println(book.getBook());
        }
    }
}