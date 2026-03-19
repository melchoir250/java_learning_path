package task_05_inventory;

public class OutOfStockException extends Exception {
    public OutOfStockException(String category) {
        super("Ошибка! В данной категории " + category + " закончились товары");
    }
}