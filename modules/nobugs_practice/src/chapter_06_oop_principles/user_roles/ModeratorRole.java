package chapter_06_oop_principles.user_roles;

import java.util.Set;

public class ModeratorRole implements Role {
    private Set<String> allowedAction = Set.of(
            "edit_content",
            "delete_comments",
            "view_reports"
    );

    @Override
    public boolean canPerform(String action) {
        return allowedAction.contains(action);
    }
}