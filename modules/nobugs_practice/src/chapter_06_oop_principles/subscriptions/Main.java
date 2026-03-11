package chapter_06_oop_principles.subscriptions;

public class Main {
    public static void main(String[] args) {
        User user = new User("Анна", new BasicSubscription());

        checkAccess(user, "watch_4k");
        checkAccess(user, "watch_sd");

        user.changeSubscription(new PremiumSubscription());
        checkAccess(user, "watch_4k");
        checkAccess(user, "exclusive_content");

        user.changeSubscription(new FamilySubscription());
        checkAccess(user, "family_sharing");
        checkAccess(user, "watch_4k");
    }

    private static void checkAccess(User user, String feature) {
        System.out.println(user.getName() + " имеет доступ к '" + feature + "': " + user.hasAccess(feature));
    }
}