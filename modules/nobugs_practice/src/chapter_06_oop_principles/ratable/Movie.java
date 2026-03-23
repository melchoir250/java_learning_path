package chapter_06_oop_principles.ratable;

public class Movie implements Ratable {
    private final String title;
    private final String year;
    private final String author;
    private final double rating;

    public Movie(String title, String year, String author, double rating) {
        this.title = title;
        this.year = year;
        this.author = author;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", author='" + author + '\'' +
                ", rating=" + rating +
                '}';
    }
}