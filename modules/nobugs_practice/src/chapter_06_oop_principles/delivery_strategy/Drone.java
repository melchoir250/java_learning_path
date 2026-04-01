package chapter_06_oop_principles.delivery_strategy;

public class Drone implements DeliveryStrategy {
    @Override
    public double calculateTime(double distance) {
        double speedDrone = 60.0;
        return (distance / speedDrone) * 60 + 5;
    }

    @Override
    public String getStrategyName() {
        return "Дрон ";
    }
}