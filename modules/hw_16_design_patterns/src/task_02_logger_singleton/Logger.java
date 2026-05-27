package task_02_logger_singleton;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static Logger instance;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private Logger() {
        System.out.println("Logger successfully created");
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    private String getCurrentTime() {
        return LocalDateTime.now().format(formatter);
    }

    public void info(String message) {
        System.out.println("[" + getCurrentTime() + "] [INFO] " + message);
    }

    public void warn(String message) {
        System.out.println("[" + getCurrentTime() + "] [WARN] " + message);
    }

    public void error(String message) {
        System.err.println("[" + getCurrentTime() + "] [ERROR] " + message);
    }
}
