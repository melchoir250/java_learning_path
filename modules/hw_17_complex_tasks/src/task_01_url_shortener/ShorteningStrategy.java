package task_01_url_shortener;

public interface ShorteningStrategy {
    String shorten(String longUrl);
}