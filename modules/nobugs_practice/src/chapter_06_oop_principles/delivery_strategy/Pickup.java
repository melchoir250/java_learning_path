package chapter_06_oop_principles.delivery_strategy;

public class Pickup implements DeliveryStrategy{
    @Override
    public double calculateTime(double distance) {
        return 20;
    }

    @Override
    public String getStrategyName() {
        return "Самовывоз ";
    }
}