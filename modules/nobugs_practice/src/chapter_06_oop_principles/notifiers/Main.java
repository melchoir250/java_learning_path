package chapter_06_oop_principles.notifiers;

public class Main {
    public static void main(String[] args) {
        Notifier emailNotifier = new EmailNotifier();
        Notifier telegramNotifier = new TelegramNotifier();
        Notifier appNotifier = new AppNotifier();

        User user1 = new User(
                "test@example.com",
                "telegram_user_123",
                "+79991234567",
                emailNotifier
        );

        User user2 = new User(
                "user2@example.com",
                "tg_user_456",
                "+79990001122",
                telegramNotifier
        );

        User user3 = new User(
                null,
                null,
                "+78889997766",
                appNotifier
        );

        NotificationService service = new NotificationService();

        service.sendNotification(user1, "Ваш заказ оформлен.");
        service.sendNotification(user2, "У вас новое сообщение.");
        service.sendNotification(user3, "В приложении доступно обновление.");

        System.out.println("----- Смена канала уведомления -----");

        user1.setPreferredNotifier(telegramNotifier);
        service.sendNotification(user1, "Способ уведомления изменен.");
    }
}
