package chapter_06_oop_principles.order_processing;

public class Main {
    public static void main(String[] args) {
        Order order1 = new Order(1001, "ivan@example.com", 250.75);
        Order order2 = new Order(1002, "maria@example.com", 520.50);

        OrderProcessingPipeline pipeline = new OrderProcessingPipeline();

        pipeline.addProcessor(new EmailConfirmation());
        pipeline.addProcessor(new InventoryUpdate());

        pipeline.processOrder(order1);

        pipeline.addProcessor(new LoyaltyPointsAdder());

        pipeline.processOrder(order2);

        System.out.println("=== Состояние заказов после обработки ===");
        System.out.printf("Заказ #%d: подтверждение=%s, склад=%s, баллы=%d\n",
                order1.getOrderId(),
                order1.isConfirmationSent(),
                order1.isInventoryUpdated(),
                order1.isLoyaltyPoints());

        System.out.printf("Заказ #%d: подтверждение=%s, склад=%s, баллы=%d\n",
                order2.getOrderId(),
                order2.isConfirmationSent(),
                order2.isInventoryUpdated(),
                order2.isLoyaltyPoints());
    }
}