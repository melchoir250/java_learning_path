package task_04_movie_rating;

import java.util.*;
import java.util.stream.Collectors;

public class MovieService {
    private final Map<Movie, List<Rating<? extends Number>>> movieRatings = new HashMap<>();

    public synchronized void addRating(Movie movie, Rating<? extends Number> rating) {
        if (movie == null) {
            throw new InvalidRatingException("Фильм не может быть null");
        }

        if (rating == null) {
            throw new InvalidRatingException("Рейтинг не может быть null");
        }

        double value = rating.getValue().doubleValue();

        if (value < 1 || value > 10) {
            throw new InvalidRatingException("Оценка должна быть в диапазоне от 1 до 10 включительно");
        }

        movieRatings.computeIfAbsent(movie, m -> new ArrayList<>()).add(rating);
    }

    public OptionalDouble getAverageRating(Movie movie) {
        if (movie == null) {
            throw new InvalidRatingException("Фильм не может быть null");
        }

        List<Rating<? extends Number>> ratings = movieRatings.get(movie);

        if (ratings == null || ratings.isEmpty()) {
            return OptionalDouble.empty();
        }

        synchronized (this) {
            return ratings.stream()
                    .mapToDouble(rating -> rating.getValue().doubleValue())
                    .average();
        }
    }

    public List<Movie> getMoviesSortedByAverageRating(boolean descending) {
        List<Movie> moviesSnapshot;

        synchronized (this) {
            moviesSnapshot = new ArrayList<>(movieRatings.keySet());
        }

        Comparator<Movie> comparator = Comparator.comparingDouble(movie -> {
            OptionalDouble average = getAverageRating(movie);
            return average.isPresent() ? average.getAsDouble() : Double.NEGATIVE_INFINITY;
        });

        if (descending) {
            comparator = comparator.reversed();
        }

        return moviesSnapshot.stream().sorted(
                (movie1, movie2) -> {
                    OptionalDouble avg1 = getAverageRating(movie1);
                    OptionalDouble avg2 = getAverageRating(movie2);

                    boolean empty1 = avg1.isEmpty();
                    boolean empty2 = avg2.isEmpty();

                    if (empty1 && empty2) {
                        return 0;
                    }
                    if (empty1) {
                        return 1;
                    }
                    if (empty2) {
                        return -1;
                    }
                    return descending
                            ? Double.compare(avg2.getAsDouble(), avg1.getAsDouble())
                            : Double.compare(avg1.getAsDouble(), avg2.getAsDouble());
                }
        ).collect(Collectors.toList());
    }

    public synchronized Map<Movie, List<Rating<? extends Number>>> getMovieRatings() {
        Map<Movie, List<Rating<? extends Number>>> copy = new HashMap<>();
        for (Map.Entry<Movie, List<Rating<? extends Number>>> entry : movieRatings.entrySet()) {
            copy.put(entry.getKey(), new ArrayList<>(entry.getValue()));
        }
        return copy;
    }
}
