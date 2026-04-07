package chapter_06_oop_principles.devices_control;

public class Fan implements Device {
    private boolean isActive = false;

    public Fan(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean isActive() {
        return isActive;
    }

    @Override
    public void turnOn() {
        if (isActive) {
            System.out.println("Фен уже включен");
        } else {
            isActive = true;
            System.out.println("Включили фен");
        }
    }

    @Override
    public void turnOff() {
        if (!isActive) {
            System.out.println("Фен выключен");
        } else {
            isActive = false;
            System.out.println("Выключил фен");
        }
    }
}