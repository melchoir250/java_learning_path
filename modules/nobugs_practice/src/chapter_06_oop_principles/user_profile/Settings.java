package chapter_06_oop_principles.user_profile;

public class Settings {
    private final String email;
    private String password;
    private boolean isActiveVerified;

    public Settings(String email, String password, boolean isActiveVerified) {
        this.email = email;
        this.password = password;
        this.isActiveVerified = isActiveVerified;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean isActiveVerified() {
        return isActiveVerified;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setActiveVerified(boolean activeVerified) {
        isActiveVerified = activeVerified;
    }
}