package chapter_06_oop_principles.notifiers;

public class NotificationService {

    public void sendNotification(User user, String message) {
        if (user == null) {
            System.out.println("Пользователь не передан.");
            return;
        }

        if (user.getPreferredNotifier() == null) {
            System.out.println("Для пользователя не выбран способ уведомления.");
            return;
        }

        user.getPreferredNotifier().notify(user, message);
    }
}
