package chapter_06_oop_principles.devices_control;

public class Main {
    public static void main(String[] args) {
        DeviceController deviceController = new DeviceController();
        Lamp lamp = new Lamp(false);
        Fan fan = new Fan(false);
        Heater heater = new Heater(false);

        deviceController.addDevice(lamp);
        deviceController.addDevice(fan);
        deviceController.addDevice(heater);

        deviceController.turnOnAll();
        deviceController.turnOffAll();
    }
}