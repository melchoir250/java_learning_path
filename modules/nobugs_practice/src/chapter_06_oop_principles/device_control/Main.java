package chapter_06_oop_principles.device_control;

public class Main {
    public static void main(String[] args) {
        Lamp lamp = new Lamp(true);
        Fan fan = new Fan(false);
        TV tv = new TV(false);

        RemoteController remoteController = new RemoteController(lamp);
        remoteController.pressOffButton();

        remoteController.setDevice(fan);
        remoteController.pressOnButton();
        remoteController.pressOffButton();

        remoteController.setDevice(tv);
        remoteController.pressOnButton();
    }
}
