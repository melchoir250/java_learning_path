package chapter_06_oop_principles.notifications;

public class EmailSender implements NotificationSender {
    @Override
    public void send(String message) {
        System.out.println("Send email: " + message);
    }
}