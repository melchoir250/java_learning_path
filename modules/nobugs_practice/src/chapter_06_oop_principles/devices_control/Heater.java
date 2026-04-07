package chapter_06_oop_principles.devices_control;

public class Heater implements Device {
    private boolean isActive = false;

    public Heater(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean isActive() {
        return isActive;
    }

    @Override
    public void turnOn() {
        if (isActive) {
            System.out.println("Обогреватель уже включен");
        } else {
            isActive = true;
            System.out.println("Включен обогреватель");
        }
    }

    @Override
    public void turnOff() {
        if (!isActive) {
            System.out.println("Обогреватель выключен");
        } else {
            isActive = false;
            System.out.println("Выключен обогреватель");
        }
    }
}