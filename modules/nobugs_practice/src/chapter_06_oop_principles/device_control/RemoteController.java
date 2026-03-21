package chapter_06_oop_principles.device_control;

public class RemoteController {
    private Switchable device;

    public RemoteController(Switchable device) {
        this.device = device;
    }

    public Switchable getDevice() {
        return device;
    }

    public void setDevice(Switchable device) {
        this.device = device;
    }

    public void pressOnButton() {
        device.turnOn();
    }

    public void pressOffButton() {
        device.turnOff();
    }
}