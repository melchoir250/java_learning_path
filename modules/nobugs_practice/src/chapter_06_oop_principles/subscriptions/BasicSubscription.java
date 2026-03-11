package chapter_06_oop_principles.subscriptions;

import java.util.Set;

public class BasicSubscription implements Subscription {
    private Set<String> allowedFeatures = Set.of("watch_sd", "basic_support");

    @Override
    public boolean canAccess(String featureName) {
        return allowedFeatures.contains(featureName);
    }
}