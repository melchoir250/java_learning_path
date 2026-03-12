package chapter_06_oop_principles.transport_management;

public abstract class Transport {
    protected double distanceTraveled;
    protected String name;

    public Transport(String name) {
        this.name = name;
        this.distanceTraveled = 0;
    }

    public abstract double getSpeed();

    public void move(int hours) {
        double speed = getSpeed();
        double distance = speed * hours;
        distanceTraveled += distance;
        System.out.printf("%s движется %d ч. со скоростью %.1f км/ч. Пройдено: %.1f км\n",
                name, hours, speed, distance);
    }

    public double getDistanceTraveled() {
        return distanceTraveled;
    }

    public String getName() {
        return name;
    }
}