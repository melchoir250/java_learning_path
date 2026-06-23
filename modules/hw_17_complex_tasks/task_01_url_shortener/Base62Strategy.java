
public class Base62Strategy implements ShorteningStrategy {
    private static final String BASE62_STRING = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private long counter = 0;

    @Override
    public String shorten(String longUrl) {
        String shortUrl = toBase62(counter);
        counter++;
        return shortUrl;
    }

    private String toBase62(long number) {
        StringBuilder sb = new StringBuilder();
        if (number == 0) return "0";
        while (number > 0) {
            sb.insert(0, BASE62_STRING.charAt((int) (number % 62)));
            number /= 62;
        }
        return sb.toString();
    }
}