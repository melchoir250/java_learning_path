package task_04_movie_rating;

import java.util.Objects;

public class Movie {
    private final String title;
    private final int year;
    private final String director;
    private final String genre;

    public Movie(String title, int year, String director, String genre) {
        this.title = title;
        this.year = year;
        this.director = director;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public String getGenre() {
        return genre;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Movie movie)) {
            return false;
        }

        return year == movie.year
                && Objects.equals(title, movie.title)
                && Objects.equals(director, movie.director)
                && Objects.equals(genre, movie.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, year, director, genre);
    }
}