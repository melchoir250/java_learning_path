package chapter_06_oop_principles.subscriptions;

import java.util.Set;

public class FamilySubscription extends PremiumSubscription {

    private Set<String> familyFeatures = Set.of(
            "family_sharing",
            "parental_controls"
    );

    @Override
    public boolean canAccess(String featureName) {
        return super.canAccess(featureName) || familyFeatures.contains(featureName);
    }
}