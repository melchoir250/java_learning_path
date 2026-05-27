package task_02_logger_singleton;

public class Main {
    public static void main(String[] args) {

        Logger logger = Logger.getInstance();
        logger.info("Подключение к базе данных");

        Logger storeLogger = Logger.getInstance();
        storeLogger.warn("Пользователь использует устаревший метод оплаты через СМС.");

        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            storeLogger.error("Произошла ошибка при расчете скидки: " + e.getMessage());
        }
    }
}
