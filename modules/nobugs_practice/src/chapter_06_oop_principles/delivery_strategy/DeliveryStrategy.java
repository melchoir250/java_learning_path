package chapter_06_oop_principles.delivery_strategy;

public interface DeliveryStrategy {
    double calculateTime(double distance);
    String getStrategyName();
}