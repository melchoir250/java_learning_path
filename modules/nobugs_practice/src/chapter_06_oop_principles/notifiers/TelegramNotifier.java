package chapter_06_oop_principles.notifiers;

public class TelegramNotifier implements Notifier {

    @Override
    public void notify(User user, String text) {
        if (user.getTelegramId() == null || user.getTelegramId().isBlank()) {
            System.out.println("Telegram ID не указан. Невозможно отправить сообщение.");
            return;
        }

        System.out.println("Отправка сообщения в Telegram пользователю "
                + user.getTelegramId() + ": " + text);
    }
}
