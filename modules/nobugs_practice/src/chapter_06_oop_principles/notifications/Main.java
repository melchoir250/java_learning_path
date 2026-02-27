package chapter_06_oop_principles.notifications;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<NotificationSender> senders = new ArrayList<>();
        senders.add(new EmailSender());
        senders.add(new SmsSender());
        senders.add(new PushSender());

        NotificationService.notifyUsers(senders, "Allert");
    }
}
