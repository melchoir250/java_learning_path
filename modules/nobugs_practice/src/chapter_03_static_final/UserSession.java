package chapter_03_static_final;

// 24. Глобальный текущий пользователь
//Реализуй механизм, позволяющий установить текущего пользователя в системе.
//В любой части программы можно получить текущего активного пользователя, но
//одновременно может быть только один.
//Пояснение: организуй глобальное хранилище состояния, при этом учитывай
//модификаторы доступа.

class UserSession {
    private static String user;

    private UserSession() {}

    public static String getUser() {
        return user;
    }

    public static void setUser(String newUser) {
        user = newUser;
    }
}
