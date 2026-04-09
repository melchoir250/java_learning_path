package mock_interviews.task2;

public class PushNotification extends NotificationAbstract {
    protected PushNotification(String recipientNotification, String textNotification) {
        super(recipientNotification, textNotification);
    }

    @Override
    public String notification() {
        return "Push отправлено на " + recipientNotification + ": " + textNotification;
    }
}