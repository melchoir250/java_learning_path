package chapter_06_oop_principles.order_processing;

public class LoyaltyPointsAdder implements OrderProcessor {
    private static final double POINTS_PERCENTAGE = 0.01;

    @Override
    public void process(Order order) {
        int points = (int) (order.getTotalAmount() * POINTS_PERCENTAGE);
        System.out.printf("[LoyaltyPointsAdder] Начислено %d бонусных баллов за заказ #%d\n",
                points, order.getOrderId());
        order.setLoyaltyPoints(points);
    }
}