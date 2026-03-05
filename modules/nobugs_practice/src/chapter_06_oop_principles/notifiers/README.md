---

### 7. Система уведомлений (Полиморфизм + Расширяемость)

```markdown
# Задача 7: Система уведомлений

## Описание
Создание гибкой системы оповещений, которую легко расширять новыми способами отправки (SMS, Push и т.д.) без изменения существующего кода клиента. В основе лежит принцип полиморфизма через интерфейсы.

## Условие
1.  Создайте класс `User` с полями (например, `email`, `telegramId`, `phone` для разных типов уведомлений).
2.  Создайте **интерфейс** `Notifier` с методом `void notify(User user, String text)`.
3.  Реализуйте несколько классов-уведомителей:
    *   `EmailNotifier` (отправляет на `user.email`).
    *   `TelegramNotifier` (отправляет в Telegram по `user.telegramId`).
    *   `AppNotifier` (отправляет push-уведомление).
4.  Реализуйте механизм, позволяющий пользователю выбрать свой канал оповещения. Например, через поле `preferredNotifier` в классе `User` или через отдельный сервис рассылки.

## Пояснение
Интерфейс `Notifier` служит контрактом. Клиентский код (сервис рассылки) работает только с интерфейсом. Благодаря этому, добавить новый `SmsNotifier` можно будет, просто создав новый класс, не трогая логику отправки.

## Пример кода (структура)
```java
interface Notifier {
    void notify(User user, String text);
}

class EmailNotifier implements Notifier {
    @Override
    public void notify(User user, String text) {
        System.out.println("Отправка email на " + user.getEmail() + ": " + text);
    }
}

class User {
    private String email;
    private Notifier notifier; // Предпочитаемый способ оповещения
    // ... геттеры, сеттеры
}

// Сервис рассылки
class NotificationService {
    public void sendNotification(User user, String message) {
        user.getNotifier().notify(user, message); // Полиморфизм!
    }
}