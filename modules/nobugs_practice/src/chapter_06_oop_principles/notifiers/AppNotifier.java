package chapter_06_oop_principles.notifiers;

public class AppNotifier implements Notifier {

    @Override
    public void notify(User user, String text) {
        System.out.println("Отправка push-уведомления в приложение: " + text);
    }
}
