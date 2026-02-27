package chapter_06_oop_principles.notifications;

public class SmsSender implements NotificationSender {
    @Override
    public void send(String message) {
        System.out.println("Send sms: " + message);
    }
}