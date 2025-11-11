package library;

public class Library {
    private String bookTitle;
    protected String author;
    int year;
    public String category;

    String getBookTitle() {
        return this.bookTitle;
    }

    String getAuthor() {
        return this.author;
    }

    int getYear() {
        return this.year;
    }

    String getCategory() {
        return this.category;
    }

    void setBookTitle(String newBookTitle) {
        this.bookTitle = newBookTitle;
    }

    void setAuthor(String newAuthor) {
        this.author = newAuthor;
    }

    void setYear(int newYear) {
        this.year = newYear;
    }

    void setCategory(String newCategory) {
        this.category = newCategory;
    }
}

class LibraryTest{
    public static void main(String[] args) {
        Library lib1 = new Library();
        System.out.println(lib1.getBookTitle());
        System.out.println(lib1.getAuthor());
        System.out.println(lib1.getYear());
        System.out.println(lib1.getCategory());
        lib1.setBookTitle("1984");
        lib1.setAuthor("Джордж Оруэлл");
        lib1.setYear(1949);
        lib1.setCategory("Роман");
        System.out.println(lib1.getBookTitle());
        System.out.println(lib1.getAuthor());
        System.out.println(lib1.getYear());
        System.out.println(lib1.getCategory());
    }
}
