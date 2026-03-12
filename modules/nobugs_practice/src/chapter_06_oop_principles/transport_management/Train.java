package chapter_06_oop_principles.transport_management;

public class Train extends Transport {
    private static final double SPEED = 150;

    public Train() {
        super("Поезд");
    }

    @Override
    public double getSpeed() {
        return SPEED;
    }
}