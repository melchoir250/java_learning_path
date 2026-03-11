package chapter_06_oop_principles.user_roles;

import java.util.Set;

public class UserRole implements Role {
    private Set<String> allowedActions = Set.of(
            "view_content",
            "create_comments",
            "edit_own_profile"
    );

    @Override
    public boolean canPerform(String action) {
        return allowedActions.contains(action);
    }
}