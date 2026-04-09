package mock_interviews.task2;

public class SmsNotification extends NotificationAbstract {
    private final int codeNotificated;

    protected SmsNotification(String recipientNotification, String textNotification, int codeNotificated) {
        super(recipientNotification, textNotification);
        this.codeNotificated = codeNotificated;
    }

    @Override
    public String notification() {
        return "SMS отправлено на " + recipientNotification + ": " + textNotification + " " + codeNotificated;
    }
}