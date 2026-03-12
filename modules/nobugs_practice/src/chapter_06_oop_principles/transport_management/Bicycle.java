package chapter_06_oop_principles.transport_management;

public class Bicycle extends Transport {
    private static final double SPEED = 20;

    public Bicycle() {
        super("Велосипед");
    }

    @Override
    public double getSpeed() {
        return SPEED;
    }
}