package mock_interviews.task2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmailNotification emailNotification = new EmailNotification(
                "alex@test.com", "Заказ готов"
        );

        PushNotification pushNotification = new PushNotification(
                "device-777", "У вас новое сообщение"
        );

        SmsNotification smsNotification = new SmsNotification(
                "+1235860384", "Код подтверждения", 8493
        );

        SmsNotification smsNotificationAdd = new SmsNotification(
                "+1233333333", "Код подтверждения", 9394
        );

        NotificationService notificationService = new NotificationService(new ArrayList<>(List.of(
                pushNotification, emailNotification, smsNotification
        )));

        notificationService.addNotification(smsNotificationAdd);

        for (Notification n : notificationService.getNotifications()) {
            System.out.println(((NotificationAbstract) n).getRecipientNotification());
        }

        notificationService.sendAll();
    }
}