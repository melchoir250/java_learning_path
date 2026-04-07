package chapter_06_oop_principles.devices_control;

public class Lamp implements Device {
    private boolean isActive = false;

    public Lamp(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean isActive() {
        return isActive;
    }

    @Override
    public void turnOn() {
        if (isActive) {
            System.out.println("Лампа уже включена");
        } else {
            isActive = true;
            System.out.println("Включили лампу");
        }
    }

    @Override
    public void turnOff() {
        if (!isActive) {
            System.out.println("Лампа уже выключена");
        } else {
            isActive = false;
            System.out.println("Выключили лампу");
        }
    }
}