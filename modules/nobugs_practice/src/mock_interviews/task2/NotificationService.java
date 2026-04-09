package mock_interviews.task2;

import java.util.ArrayList;
import java.util.List;

public class NotificationService {
    private List<Notification> notifications = new ArrayList<>();

    public NotificationService(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void addNotification(Notification n) {
        notifications.add(n);
    }

    public void sendAll() {
        for (Notification item : notifications) {
            System.out.println(item.notification());
        }
    }
}