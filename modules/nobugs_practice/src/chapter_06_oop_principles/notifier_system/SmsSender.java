package chapter_06_oop_principles.notifier_system;

public class SmsSender implements NotificationSender {
    @Override
    public void send(String message) {
        System.out.println("Send sms: " + message);
    }
}