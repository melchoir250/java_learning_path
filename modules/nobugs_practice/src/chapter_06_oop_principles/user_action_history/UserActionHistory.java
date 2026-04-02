package chapter_06_oop_principles.user_action_history;

import java.util.ArrayList;
import java.util.List;

public class UserActionHistory {
    private final List<String> history = new ArrayList<>();

    public void addAction(String action) {
        history.add(action);
    }

    public List<String> getAll() {
        return new ArrayList<>(history);
    }

    public String getLastAction() {
        int size = history.size();
        if (size == 0) {
            return null;
        } else {
            return history.get(size - 1);
        }
    }
}