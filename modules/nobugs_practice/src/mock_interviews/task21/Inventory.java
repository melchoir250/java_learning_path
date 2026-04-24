package mock_interviews.task21;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private final Map<String, Integer> items;

    public Inventory() {
        this.items = new HashMap<>();
    }

    public void addItem(String name, int amount) {
        if (amount <= 0) return;
        int currentAmount = items.getOrDefault(name, 0);
        items.put(name, currentAmount + amount);
        System.out.println("Добавлено: " + name + " (" + amount + " шт.). Всего: " + (currentAmount + amount));
    }

    public void useItem(String name) {
        if (!items.containsKey(name)) {
            System.out.println("Предмет " + name + " - нет в инвентаре.");
            return;
        }
        int currentAmount = items.get(name);
        int newAmount = currentAmount - 1;
        if (newAmount > 0) {
            items.put(name, newAmount);
            System.out.println("Вы использовали " + name + ". Осталось: " + newAmount);
        } else {
            items.remove(name);
            System.out.println("Вы использовали последний " + name + ". Предмет закончился.");
        }
    }

    public int getAmount(String name) {
        return items.getOrDefault(name, 0);
    }

    public boolean hasItem(String name) {
        return items.containsKey(name);
    }

    public int getDifferentItemsCount() {
        return items.size();
    }
}