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
        Library library1 = new Library();
        System.out.println(library1.getBookTitle());
        System.out.println(library1.getAuthor());
        System.out.println(library1.getYear());
        System.out.println(library1.getCategory());
        library1.setBookTitle("1984");
        library1.setAuthor("Джордж Оурелл");
        library1.setYear(1949);
        library1.setCategory("Роман");
        System.out.println(library1.getBookTitle());
        System.out.println(library1.getAuthor());
        System.out.println(library1.getYear());
        System.out.println(library1.getCategory());
    }
}
