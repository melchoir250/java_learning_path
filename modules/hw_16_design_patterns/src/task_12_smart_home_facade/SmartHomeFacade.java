package task_12_smart_home_facade;

public class SmartHomeFacade {
    private final Light light;
    private final AirConditioner airConditioner;
    private final SecuritySystem securitySystem;

    public SmartHomeFacade() {
        this.light = new Light();
        this.airConditioner = new AirConditioner();
        this.securitySystem = new SecuritySystem();
    }

    public void turnEverythingOn() {
        light.turnOn();
        airConditioner.turnOn();
        securitySystem.activate();
    }

    public void turnEverythingOff() {
        light.turnOff();
        airConditioner.turnOff();
        securitySystem.deactivate();
    }
}
