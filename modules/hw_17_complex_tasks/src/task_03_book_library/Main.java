package task_03_book_library;

public class Main {
    public static void main(String[] args) {
        Book book = new BookBuilder()
                .setTitle("War and Peace")
                .setAuthor("Leo Tolstoy")
                .setDescription("A historical novel about the Napoleonic Wars.")
                .build();

        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("Content in Book (before proxy): " + book.getContent());

        BookProxy proxy = new BookProxy(book);

        String content1 = proxy.getContent();
        System.out.println("Content: " + content1);

        String content2 = proxy.getContent();
        System.out.println("Content: " + content2);
    }
}
