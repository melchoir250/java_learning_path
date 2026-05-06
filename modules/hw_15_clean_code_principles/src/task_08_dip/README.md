# Задача 8: Исправление нарушения DIP

## Описание проблемы

Исходный код нарушает принцип DIP (Dependency Inversion Principle):

- Класс `NotificationService` зависит напрямую от конкретного класса `EmailSender`
- Высокоуровневый модуль зависит от низкоуровневого модуля
- Сложно заменить способ отправки уведомлений (например, на SMS или Push)
- Код трудно тестировать, так как нельзя подставить mock-объект

## Исходный код

```java
public class NotificationService {
    private EmailSender emailSender = new EmailSender();

    public void sendNotification(String message) {
        emailSender.sendEmail(message);
    }
}

class EmailSender {
    public void sendEmail(String message) {
        System.out.println("Отправка email: " + message);
    }
}
```

## Задача

Используйте интерфейсы и внедрение зависимостей, чтобы ослабить связь между классами.
