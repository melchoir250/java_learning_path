package chapter_06_oop_principles.book_metadata;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Clean Code", "Robert C. Martin", "9780132350884", 2008, "Prentice Hall", 464);
        Book book2 = new Book("Effective Java", "Joshua Bloch", "9780134685991", 2018, "Addison-Wesley", 416);
        Book book3 = new Book("Design Patterns", "Erich Gamma", "9780201633610", 1994, "Addison-Wesley", 395);
        Book book4 = new Book("Refactoring", "Martin Fowler", "9780201485677", 1999, "Addison-Wesley", 448);

        System.out.println(book1.getTitle() + " - " + book1.getAuthor());
        System.out.println(book2.getTitle() + " - " + book2.getAuthor());
        System.out.println(book3.getTitle() + " - " + book3.getAuthor());
        System.out.println(book4.getTitle() + " - " + book4.getAuthor());
    }
}