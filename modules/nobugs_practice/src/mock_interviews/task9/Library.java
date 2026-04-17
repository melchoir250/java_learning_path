package mock_interviews.task9;

import com.sun.source.tree.LiteralTree;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> bookList;

    public Library() {
        this.bookList = new ArrayList<>();
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void addBookList(List<Book> bookList) {
        for (Book book : bookList) {
            this.bookList.add(book);
        }
    }

    public String getSearchBookList(String titleToSearch) {
        for (Book item : bookList) {
            if (item.getNameBook().equals(titleToSearch)) {
                return item.toString();
            }
        }
        return "Книга не найдена";
    }

    public void giveBook(String title) {
        for (Book item : bookList) {
            if (item.getNameBook().equals(title)) {

                if (item.getCountBook() > 0) {
                    item.setCountBook(item.getCountBook() - 1);
                    System.out.println("Выдана: " + item.getNameBook() + ", теперь: " + item.getCountBook());
                } else {
                    System.out.println("Нет в наличии");
                }

                return;
            }
        }

        System.out.println("Книга не найдена");
    }

    public void addBook(String title) {
        for (Book item : bookList) {
            if (item.getNameBook().equals(title)) {

                item.setCountBook(item.getCountBook() + 1);
                System.out.println("Возвращена: " + item.getNameBook() +
                        ", теперь: " + item.getCountBook());

                return;
            }
        }

        System.out.println("Книга не найдена");
    }
}