package chapter_06_oop_principles.user_roles;

class User {
    private String username;
    private Role role;

    public User(String username, Role role) {
        this.username = username;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public Role getRole() {
        return role;
    }

    public void changeRole(Role newRole) {
        this.role = newRole;
        System.out.println(username + " сменил роль на " + newRole.getClass().getSimpleName());
    }

    public boolean hasPermission(String action) {
        return role.canPerform(action);
    }

    public void performAction(String action) {
        if (hasPermission(action)) {
            System.out.println(username + " выполнил действие: " + action);
        } else {
            System.out.println(username + " НЕ может выполнить действие: " + action + " (доступ запрещён)");
        }
    }
}