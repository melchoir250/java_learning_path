package chapter_06_oop_principles.order_processing;

public class InventoryUpdate implements OrderProcessor {
    @Override
    public void process(Order order) {
        System.out.printf("[InventoryUpdate] Склад обновлён для заказа #%d. Списано товаров на сумму $%.2f\n",
                order.getOrderId(), order.getTotalAmount());
        order.setInventoryUpdated(true);
    }
}