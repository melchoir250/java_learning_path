package chapter_06_oop_principles.device_control;

public class TV implements Switchable {
    private boolean isOn = false;

    public TV(boolean isOn) {
        this.isOn = isOn;
    }

    public boolean isOn() {
        return isOn;
    }

    @Override
    public void turnOn() {
        if (!isOn) {
            isOn = true;
            System.out.println("Телевизор включился");
        } else {
            System.out.println("Телевизор включен");
        }
    }

    @Override
    public void turnOff() {
        if (!isOn) {
            System.out.println("Телевизор выключился");
        } else {
            isOn = false;
            System.out.println("Телевизор выключен");
        }
    }
}
