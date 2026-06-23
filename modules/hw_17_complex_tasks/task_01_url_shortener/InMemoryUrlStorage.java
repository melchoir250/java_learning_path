import java.util.HashMap;
import java.util.Map;

public class InMemoryUrlStorage implements UrlStorage {
    private static InMemoryUrlStorage instance;
    private final Map<String, String> shortToLong = new HashMap<>();
    private final Map<String, String> longToShort = new HashMap<>();

    private InMemoryUrlStorage() {
    }

    public static InMemoryUrlStorage getInstance() {
        if (instance == null) {
            instance = new InMemoryUrlStorage();
        }
        return instance;
    }

    @Override
    public void save(String shortUrl, String longUrl) {
        shortToLong.put(shortUrl, longUrl);
        longToShort.put(longUrl, shortUrl);
    }

    @Override
    public String findLongUrl(String shortUrl) {
        return shortToLong.get(shortUrl);
    }

    @Override
    public String findShortUrl(String longUrl) {
        return longToShort.get(longUrl);
    }
}
