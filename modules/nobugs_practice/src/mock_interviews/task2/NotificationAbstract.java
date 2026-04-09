package mock_interviews.task2;

public abstract class NotificationAbstract implements Notification {
    protected String recipientNotification;
    protected String textNotification;

    protected NotificationAbstract(String recipientNotification, String textNotification) {
        this.recipientNotification = recipientNotification;
        this.textNotification = textNotification;
    }

    protected String getRecipientNotification() {
        return recipientNotification;
    }

    protected String getTextNotification() {
        return textNotification;
    }

    protected void setRecipientNotification(String recipientNotification) {
        this.recipientNotification = recipientNotification;
    }

    protected void setTextNotification(String textNotification) {
        this.textNotification = textNotification;
    }
}