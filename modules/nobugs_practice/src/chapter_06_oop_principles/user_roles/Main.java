package chapter_06_oop_principles.user_roles;

public class Main {
    public static void main(String[] args) {
        User admin = new User("Алиса", new AdminRole());
        User moderator = new User("Борис", new ModeratorRole());
        User regular = new User("Виктор", new UserRole());

        admin.performAction("manage_users");
        admin.performAction("delete_comments");
        admin.performAction("anything_really");

        moderator.performAction("edit_content");
        moderator.performAction("manage_users");
        moderator.performAction("view_reports");

        regular.performAction("view_content");
        regular.performAction("delete_comments");
        regular.performAction("edit_own_profile");

        regular.changeRole(new ModeratorRole());
        regular.performAction("delete_comments");
        regular.performAction("manage_users");
    }
}