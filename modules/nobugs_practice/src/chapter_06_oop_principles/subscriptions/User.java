package chapter_06_oop_principles.subscriptions;

class User {
    private String name;
    private Subscription subscription;

    public User(String name, Subscription subscription) {
        this.name = name;
        this.subscription = subscription;
    }

    public void changeSubscription(Subscription newSubscription) {
        this.subscription = newSubscription;
        System.out.println(name + " сменил подписку на " + newSubscription.getClass().getSimpleName());
    }

    public boolean hasAccess(String feature) {
        return subscription.canAccess(feature);
    }

    public String getName() {
        return name;
    }
}