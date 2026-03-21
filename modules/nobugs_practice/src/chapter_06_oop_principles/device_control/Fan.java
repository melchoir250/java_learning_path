package chapter_06_oop_principles.device_control;

public class Fan implements Switchable {
    private boolean isOn = false;

    public Fan(boolean isOn) {
        this.isOn = isOn;
    }

    public boolean isOn() {
        return isOn;
    }

    @Override
    public void turnOn() {
        if (!isOn) {
            isOn = true;
            System.out.println("Лопасти вентилятора закрутились");
        } else {
            System.out.println("Вентилятор включен");
        }
    }

    @Override
    public void turnOff() {
        if (!isOn) {
            System.out.println("Лопасти вентилятора остановились");
        } else {
            isOn = false;
            System.out.println("Вентилятор выключен");
        }
    }
}