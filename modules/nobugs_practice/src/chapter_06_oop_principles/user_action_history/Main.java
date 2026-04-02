package chapter_06_oop_principles.user_action_history;

public class Main {
    public static void main(String[] args) {
        UserActionHistory userActionHistory = new UserActionHistory();
        System.out.println(userActionHistory.getLastAction());
        userActionHistory.addAction("111");
        userActionHistory.addAction("112");
        userActionHistory.addAction("113");
        System.out.println(userActionHistory.getLastAction());
        System.out.println(userActionHistory.getAll());
    }
}