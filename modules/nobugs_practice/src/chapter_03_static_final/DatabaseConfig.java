package chapter_03_static_final;

// 25. Конфигурация подключения к БД
//Создай класс, содержащий настройки подключения к базе данных (например, хост,
//порт, имя базы).
//Эти значения устанавливаются один раз при запуске программы и далее доступны
//только для чтения.
//Пояснение: применяй финальные поля и организуй доступ без возможности
//изменения.

public class DatabaseConfig {
    private static final String host;
    private static final int port;
    private static final String nameDataBase;

    private DatabaseConfig() {}

    public static String getHost() {
        return host;
    }

    public static int getPort() {
        return port;
    }

    public static String getNameDataBase() {
        return nameDataBase;
    }

    static {
        host = "localhost";
        port = 5432;
        nameDataBase = "mydb";
    }

    public static void main(String[] args) {
        System.out.println(getHost());
        System.out.println(getPort());
        System.out.println(getNameDataBase());
    }
}
