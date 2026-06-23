public interface UrlStorage {
    void save(String shortUrl, String longUrl);
    String findLongUrl(String shortUrl);
    String findShortUrl(String longUrl);
}