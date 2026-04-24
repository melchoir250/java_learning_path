package mock_interviews.task19;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private final Map<String, Integer> stock;

    public Warehouse() {
        this.stock = new HashMap<>();
    }

    public void addProduct(String name, int amount) {
        if (amount <= 0) {
            System.out.println("Количество должно быть положительным.");
            return;
        }
        int currentAmount = stock.getOrDefault(name, 0);
        stock.put(name, currentAmount + amount);

        System.out.println("Добавлено " + name + ": " + amount + ". Всего: " + (currentAmount + amount));
    }

    public void removeProduct(String name, int amount) {
        if (!stock.containsKey(name)) {
            System.out.println("Товар " + name + " отсутствует на складе.");
            return;
        }
        int currentAmount = stock.get(name);
        if (amount > currentAmount) {
            System.out.println("Недостаточно товара " + name + ". В наличии: " + currentAmount);
        } else {
            int newAmount = currentAmount - amount;
            if (newAmount == 0) {
                stock.remove(name);
                System.out.println("Товар " + name + " полностью списан и удален со склада.");
            } else {
                stock.put(name, newAmount);
                System.out.println("Списано " + name + ": " + amount + ". Осталось: " + newAmount);
            }
        }
    }

    public int getBalance(String name) {
        return stock.getOrDefault(name, 0);
    }

    public boolean isAvailable(String name) {
        return stock.containsKey(name);
    }

    public int getProductTypesCount() {
        return stock.size();
    }
}