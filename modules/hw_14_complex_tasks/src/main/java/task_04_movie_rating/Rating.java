package task_04_movie_rating;

public class Rating<T extends Number> {
    private final T value;
    private final String username;

    public Rating(T value, String username) {
        if (value == null) {
            throw new InvalidRatingException("Оценка не может быть null");
        }
        this.value = value;
        this.username = username;
    }

    public T getValue() {
        return value;
    }

    public String getUsername() {
        return username;
    }
}
