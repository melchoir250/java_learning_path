package task_04_movie_rating;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.OptionalDouble;

import static org.junit.jupiter.api.Assertions.*;

public class MovieServiceTest {
    private MovieService movieService;
    private Movie intersellar;
    private Movie marsianin;
    private Movie spiderMan;

    @BeforeEach
    void setUp() {
        movieService = new MovieService();
        intersellar = new Movie("Интерстеллар", 2014, "Нолан", "Космос");
        marsianin = new Movie("Марсианин", 2015, "Скот", "Космос");
        spiderMan = new Movie("Человек Паук 4", 2026, "Marvel", "Марвел");
    }

    @Test
    public void shouldAddValidIntegerRating() {
        assertDoesNotThrow(() -> movieService.addRating(intersellar, new Rating<>(9, "user1")));
    }

    @Test
    public void shouldAddValidDoubleRating() {
        assertDoesNotThrow(() -> movieService.addRating(intersellar, new Rating<>(9.5, "user2")));
    }

    @Test
    public void shouldThrowExceptionRatingLess() {
        InvalidRatingException exception = assertThrows(
                InvalidRatingException.class,
                () -> movieService.addRating(marsianin, new Rating<>(0, "user3")));

        assertEquals(
                "Оценка должна быть в диапазоне от 1 до 10 включительно",
                exception.getMessage()
        );
    }

    @Test
    public void shouldRatingAverage() {
        movieService.addRating(spiderMan, new Rating<>(10, "user1"));
        movieService.addRating(spiderMan, new Rating<>(8, "user2"));

        OptionalDouble optionalDouble = movieService.getAverageRating(spiderMan);

        assertTrue(optionalDouble.isPresent());
        assertEquals(9.0, optionalDouble.getAsDouble());
    }

    @Test
    public void shouldReturnEmptyRatingMovie() {
        OptionalDouble optionalDouble = movieService.getAverageRating(marsianin);
        assertTrue(optionalDouble.isEmpty());
    }

    @Test
    public void shouldSortedMoviesAverage() {
        movieService.addRating(intersellar, new Rating<>(10, "user1"));
        movieService.addRating(intersellar, new Rating<>(8, "user2"));

        movieService.addRating(marsianin, new Rating<>(7, "user3"));
        movieService.addRating(marsianin, new Rating<>(7, "user4"));

        movieService.addRating(spiderMan, new Rating<>(9, "user5"));

        List<Movie> movies = movieService.getMoviesSortedByAverageRating(true);

        assertEquals(3, movies.size());

        assertTrue(movies.indexOf(intersellar) < movies.indexOf(marsianin));
        assertTrue(movies.indexOf(spiderMan) < movies.indexOf(marsianin));
    }

    @Test
    public void shouldSortedMoviesAverageRating() {
        movieService.addRating(intersellar, new Rating<>(10, "user1"));
        movieService.addRating(intersellar, new Rating<>(9, "user2"));

        movieService.addRating(marsianin, new Rating<>(8, "user3"));
        movieService.addRating(marsianin, new Rating<>(7, "user4"));

        movieService.addRating(spiderMan, new Rating<>(7, "user5"));

        List<Movie> movies = movieService.getMoviesSortedByAverageRating(false);

        assertEquals(intersellar, movies.get(2));
        assertEquals(marsianin, movies.get(1));
        assertEquals(spiderMan, movies.get(0));
    }
}