package mock_interviews.task2;

public class EmailNotification extends NotificationAbstract {
    protected EmailNotification(String recipientNotification, String textNotification) {
        super(recipientNotification, textNotification);
    }

    @Override
    public String notification() {
        return "Email отправлен на " + recipientNotification + ": " + textNotification;
    }
}