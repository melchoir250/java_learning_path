package task_01_url_shortener;

public interface UrlStorage {
    void save(String shortUrl, String longUrl);
    String findLongUrl(String shortUrl);
    String findShortUrl(String longUrl);
}