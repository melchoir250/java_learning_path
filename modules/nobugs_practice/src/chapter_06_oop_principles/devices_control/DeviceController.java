package chapter_06_oop_principles.devices_control;

import java.util.ArrayList;
import java.util.List;

public class DeviceController {
    private final List<Device> devices = new ArrayList<>();

    public List<Device> getDevices() {
        return devices;
    }

    public void addDevice(Device device) {
        devices.add(device);
    }

    public void turnOnAll() {
        for (Device d : devices) {
            d.turnOn();
        }
    }

    public void turnOffAll() {
        for (Device d : devices) {
            d.turnOff();
        }
    }
}