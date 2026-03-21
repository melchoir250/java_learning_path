package chapter_06_oop_principles.device_control;

public class Lamp implements Switchable {
    private boolean isOn = false;

    public Lamp(boolean isOn) {
        this.isOn = isOn;
    }

    public boolean isOn() {
        return isOn;
    }

    @Override
    public void turnOn() {
        if (!isOn) {
            isOn = true;
            System.out.println("Включили лампу");
        } else {
            System.out.println("Лампа включена");
        }
    }

    @Override
    public void turnOff() {
        if (!isOn) {
            System.out.println("Лампа выключена");
        } else {
            isOn = false;
            System.out.println("Выключили лампу");
        }
    }
}