package chapter_06_oop_principles.user_roles;

public class AdminRole implements Role {
    @Override
    public boolean canPerform(String action) {
        return true;
    }
}