package chapter_06_oop_principles.transport_management;

public class Car extends Transport {
    private static final double SPEED = 90;

    public Car() {
        super("Автомобиль");
    }

    @Override
    public double getSpeed() {
        return SPEED;
    }
}