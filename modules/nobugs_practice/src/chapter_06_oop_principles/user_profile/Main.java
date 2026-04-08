package chapter_06_oop_principles.user_profile;

public class Main {
    public static void main(String[] args) {
        Settings settingsUser1 = new Settings("user1@gmail.com", "1234567", true);
        Settings settingsUser2 = new Settings("user2@gmail.com", "4566788", false);
        Preferences preferences1 = new Preferences("Dark", true);
        Preferences preferences2 = new Preferences("DarkMaterial", false);

        UserProfile userProfile1 = new UserProfile(settingsUser1, preferences1);
        UserProfile userProfile2 = new UserProfile(settingsUser2, preferences2);

        System.out.println(userProfile1.getEmail() + " " + userProfile1.getTheme());
        System.out.println(userProfile2.getEmail() + " " + userProfile2.getTheme());

        userProfile1.changeTheme("Light");
        System.out.println(userProfile1.getEmail() + " " + userProfile1.getTheme());
    }
}