package task_04_movie_rating;

public class InvalidRatingException extends RuntimeException {
    public InvalidRatingException(String message) {
        super(message);
    }
}
