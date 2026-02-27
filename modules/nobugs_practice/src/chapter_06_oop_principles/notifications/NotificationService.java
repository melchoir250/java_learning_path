package chapter_06_oop_principles.notifications;

import java.util.List;

public class NotificationService {

    public static void notifyUsers(List<NotificationSender> senders, String msg) {
        for (NotificationSender sender : senders) {
            sender.send(msg);
        }
    }
}