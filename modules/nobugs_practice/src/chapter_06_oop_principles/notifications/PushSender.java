package chapter_06_oop_principles.notifications;

public class PushSender implements NotificationSender {
    @Override
    public void send(String message) {
        System.out.println("Send push: " + message);
    }
}