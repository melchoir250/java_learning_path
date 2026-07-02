package task_01_url_shortener;


public class Main {
    public static void main(String[] args) {
        ShorteningStrategy strategy = new Base62Strategy();
        UrlStorage storage = InMemoryUrlStorage.getInstance();

        String longUrl = "https://example.com/very/long/url";

        String shortUrl = shortenUrl(strategy, storage, longUrl);
        System.out.println("Short URL: " + shortUrl);

        String restoredUrl = expandUrl(storage, shortUrl);
        System.out.println("Original URL: " + restoredUrl);

        String shortUrlAgain = shortenUrl(strategy, storage, longUrl);
        System.out.println("Same short URL: " + shortUrlAgain);
    }

    private static String shortenUrl(ShorteningStrategy strategy, UrlStorage storage, String longUrl) {
        String existingShort = storage.findShortUrl(longUrl);
        if (existingShort != null) {
            return existingShort;
        }

        String shortUrl = strategy.shorten(longUrl);
        storage.save(shortUrl, longUrl);
        return shortUrl;
    }

    private static String expandUrl(UrlStorage storage, String shortUrl) {
        String longUrl = storage.findLongUrl(shortUrl);
        if (longUrl == null) {
            throw new IllegalArgumentException("Short URL not found: " + shortUrl);
        }
        return longUrl;
    }
}
