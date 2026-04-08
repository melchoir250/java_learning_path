package chapter_06_oop_principles.user_profile;

public class Preferences {
    private String theme;
    private boolean notificationsEnabled;

    public Preferences(String theme, boolean notificationsEnabled) {
        this.theme = theme;
        this.notificationsEnabled = notificationsEnabled;
    }

    public boolean isNotificationsEnabled() {
        return notificationsEnabled;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public void setNotificationsEnabled(boolean notificationsEnabled) {
        this.notificationsEnabled = notificationsEnabled;
    }
}