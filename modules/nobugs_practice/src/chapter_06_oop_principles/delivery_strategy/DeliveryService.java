package chapter_06_oop_principles.delivery_strategy;

public class DeliveryService {
    private DeliveryStrategy deliveryStrategy;

    public DeliveryService(DeliveryStrategy deliveryStrategy) {
        this.deliveryStrategy = deliveryStrategy;
    }

    public String getDeliveryStrategy() {
        return deliveryStrategy.getStrategyName();
    }

    public void setDeliveryStrategy(DeliveryStrategy deliveryStrategy) {
        this.deliveryStrategy = deliveryStrategy;
    }

    public double calculate(double distance) {
        return deliveryStrategy.calculateTime(distance);
    }
}