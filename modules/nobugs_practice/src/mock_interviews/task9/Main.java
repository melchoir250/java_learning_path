package mock_interviews.task9;

import java.util.Arrays;
import java.util.List;

public  class Main {
    public static void main(String[] args) {
        Book book1 = new Book("1984", "Оруэлл", 5);
        Book book2 = new Book("Война и мир", "Толстой", 3);
        Book book3 = new Book("Преступление и наказание", "Достоевский", 4);
        Book book4 = new Book("Мастер и Маргарита", "Булгаков", 2);
        Book book5 = new Book("Гарри Поттер и философский камень", "Роулинг", 7);
        List<Book> books = Arrays.asList(book1, book2, book3, book4, book5);

        Library library = new Library();
        library.addBookList(books);
        System.out.println(library.getSearchBookList("1984"));

        library.giveBook("1984");

        library.addBook("1984");
    }
}