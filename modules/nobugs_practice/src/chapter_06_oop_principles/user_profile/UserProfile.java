package chapter_06_oop_principles.user_profile;

public class UserProfile {
    private Settings settings;
    private Preferences preferences;

    public UserProfile(Settings settings, Preferences preferences) {
        this.settings = settings;
        this.preferences = preferences;
    }

    public String getEmail() {
        return settings.getEmail();
    }

    public String getTheme() {
        return preferences.getTheme();
    }

    public void changePassword(String newPassword) {
        settings.setPassword(newPassword);
    }

    public void changeTheme(String newTheme) {
        preferences.setTheme(newTheme);
    }
}