package chapter_06_oop_principles.delivery_strategy;

public class Courier implements DeliveryStrategy{
    @Override
    public double calculateTime(double distance) {
        double speedCourier = 5.0;
        return (distance / speedCourier) * 60;
    }

    @Override
    public String getStrategyName() {
        return "Курьер ";
    }
}