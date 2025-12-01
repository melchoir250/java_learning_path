package chapter_03_static_final;

// Создай структуру, где перечислены возможные роли пользователей в системе
//("admin", "user", "moderator", и т.д.).
//Эти значения должны быть доступны в любом месте и не должны меняться.
//Пояснение: используй способ задания констант в классе или интерфейсе.

public class StructureUser {
    static final String ADMIN = "admin";
    static final String USER = "user";
    static final String MODERATED = "moderator";
}
