---

# Задача: Пользователь и роли (Инкапсуляция + Расширяемость)

## Описание
Создание гибкой системы управления доступом на основе ролей. Задача демонстрирует принципы **инкапсуляции** (логика проверки прав скрыта внутри классов ролей) и **расширяемости** (новые роли и действия добавляются без изменения кода пользователя). Это классический подход к разделению ответственности: пользователь хранит данные, роль определяет поведение (что можно делать).

## Условие
1.  Создайте **интерфейс** `Role` с методом `boolean canPerform(String action)`.
2.  Реализуйте три класса ролей:
    *   **`Admin`** — администратор. Может выполнять любые действия (всегда возвращает `true`).
    *   **`Moderator`** — модератор. Может выполнять действия: `"edit_content"`, `"delete_comments"`, `"view_reports"`. Не может управлять пользователями (`"manage_users"`).
    *   **`User`** — обычный пользователь. Может выполнять только базовые действия: `"view_content"`, `"create_comments"`, `"edit_own_profile"`.
3.  Создайте класс **`User`** (пользователь системы):
    *   Поля: `String username`, `Role role` (текущая роль).
    *   Конструктор, геттеры/сеттеры для роли.
    *   Метод `boolean hasPermission(String action)` — делегирует проверку текущей роли (`role.canPerform(action)`).
    *   Метод `void changeRole(Role newRole)` — позволяет сменить роль пользователя.
4.  В методе `main` продемонстрируйте:
    *   Создание пользователей с разными ролями.
    *   Проверку доступа к различным действиям.
    *   Смену роли и повторную проверку доступа.
    *   Попытку выполнить запрещённое действие (отказ в доступе).

## Пояснение
Это задача на **отделение данных от логики**. Класс `User` не содержит запутанных `if-else` конструкций вида `if (role.equals("admin")) ...`. Вместо этого логика проверки доступа инкапсулирована в конкретных классах ролей. Пользователь просто хранит ссылку на объект роли и делегирует ей проверку прав. Это делает код более чистым, тестируемым и легким для расширения (новые роли добавляются как новые классы, реализующие интерфейс `Role`).

## Пример кода (структура)

```java
import java.util.Set;

// Интерфейс роли
interface Role {
    boolean canPerform(String action);
}

// Роль Администратор
class Admin implements Role {
    @Override
    public boolean canPerform(String action) {
        return true; // Администратор может всё
    }
}

// Роль Модератор
class Moderator implements Role {
    private Set<String> allowedActions = Set.of(
        "edit_content", 
        "delete_comments", 
        "view_reports"
    );
    
    @Override
    public boolean canPerform(String action) {
        return allowedActions.contains(action);
    }
}

// Роль Обычный пользователь
class RegularUser implements Role {
    private Set<String> allowedActions = Set.of(
        "view_content", 
        "create_comments", 
        "edit_own_profile"
    );
    
    @Override
    public boolean canPerform(String action) {
        return allowedActions.contains(action);
    }
}

// Класс пользователя системы
class User {
    private String username;
    private Role role;
    
    public User(String username, Role role) {
        this.username = username;
        this.role = role;
    }
    
    public String getUsername() {
        return username;
    }
    
    public Role getRole() {
        return role;
    }
    
    public void changeRole(Role newRole) {
        this.role = newRole;
        System.out.println(username + " сменил роль на " + newRole.getClass().getSimpleName());
    }
    
    public boolean hasPermission(String action) {
        return role.canPerform(action);
    }
    
    // Метод для демонстрации попытки выполнения действия
    public void performAction(String action) {
        if (hasPermission(action)) {
            System.out.println(username + " выполнил действие: " + action);
        } else {
            System.out.println(username + " НЕ может выполнить действие: " + action + " (доступ запрещён)");
        }
    }
}

// Демонстрация
public class Main {
    public static void main(String[] args) {
        // Создаём пользователей с разными ролями
        User admin = new User("Алиса", new Admin());
        User moderator = new User("Борис", new Moderator());
        User regular = new User("Виктор", new RegularUser());
        
        System.out.println("=== Проверка доступа ===");
        
        // Проверяем разные действия
        admin.performAction("manage_users");
        admin.performAction("delete_comments");
        admin.performAction("anything_really");
        
        System.out.println();
        
        moderator.performAction("edit_content");
        moderator.performAction("manage_users"); // Должен быть запрет
        moderator.performAction("view_reports");
        
        System.out.println();
        
        regular.performAction("view_content");
        regular.performAction("delete_comments"); // Должен быть запрет
        regular.performAction("edit_own_profile");
        
        System.out.println("\n=== Смена роли ===");
        
        // Меняем роль обычного пользователя на модератора
        regular.changeRole(new Moderator());
        regular.performAction("delete_comments"); // Теперь может
        regular.performAction("manage_users"); // А этого всё ещё нельзя
    }
}
```

## Ключевые моменты реализации

*   **Интерфейс `Role` как контракт**: Гарантирует, что любая роль умеет проверять разрешения на действие.
*   **Инкапсуляция логики доступа**: Каждая роль сама знает, какие действия ей разрешены. Никаких `if (role instanceof Admin)` в коде пользователя.
*   **Композиция**: Класс `User` содержит ссылку на объект `Role` (отношение "has-a"), а не наследует конкретную роль.
*   **Делегирование**: Метод `hasPermission()` просто передаёт управление методу `canPerform()` текущей роли.
*   **Расширяемость**: Чтобы добавить новую роль (например, `Guest` или `SuperAdmin`), достаточно создать новый класс, реализующий `Role`. Код `User` и существующих ролей не меняется.

## Ожидаемый результат

При запуске программы мы увидим, как разные роли имеют разный набор разрешений, и как смена роли динамически меняет доступ пользователя:

```
=== Проверка доступа ===
Алиса выполнил действие: manage_users
Алиса выполнил действие: delete_comments
Алиса выполнил действие: anything_really

Борис выполнил действие: edit_content
Борис НЕ может выполнить действие: manage_users (доступ запрещён)
Борис выполнил действие: view_reports

Виктор выполнил действие: view_content
Виктор НЕ может выполнить действие: delete_comments (доступ запрещён)
Виктор выполнил действие: edit_own_profile

=== Смена роли ===
Виктор сменил роль на Moderator
Виктор выполнил действие: delete_comments
Виктор НЕ может выполнить действие: manage_users (доступ запрещён)
```
