package chapter_06_oop_principles.notifiers;

public class EmailNotifier implements Notifier {

    @Override
    public void notify(User user, String text) {
        if (user.getEmail() == null || user.getEmail().isBlank()) {
            System.out.println("Email не указан. Невозможно отправить сообщение.");
            return;
        }

        System.out.println("Отправка email на " + user.getEmail() + ": " + text);
    }
}
