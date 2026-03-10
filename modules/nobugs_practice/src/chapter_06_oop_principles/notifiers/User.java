package chapter_06_oop_principles.notifiers;

public class User {
    private String email;
    private String telegramId;
    private String phone;
    private Notifier preferredNotifier;

    public User(String email, String telegramId, String phone, Notifier preferredNotifier) {
        this.email = email;
        this.telegramId = telegramId;
        this.phone = phone;
        this.preferredNotifier = preferredNotifier;
    }

    public String getEmail() {
        return email;
    }

    public String getTelegramId() {
        return telegramId;
    }

    public String getPhone() {
        return phone;
    }

    public Notifier getPreferredNotifier() {
        return preferredNotifier;
    }

    public void setPreferredNotifier(Notifier preferredNotifier) {
        this.preferredNotifier = preferredNotifier;
    }
}