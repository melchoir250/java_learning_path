package chapter_06_oop_principles.subscriptions;

import java.util.Set;

public class PremiumSubscription implements Subscription {
    private Set<String> allowedFeatures = Set.of(
            "watch_sd", "watch_hd", "watch_4k",
            "basic_support", "priority_support",
            "exclusive_content"
    );

    @Override
    public boolean canAccess(String featureName) {
        return allowedFeatures.contains(featureName);
    }
}