package task_03_vehicle_factory_method;

public class Car implements Transport {
    @Override
    public void startEngine() {
        System.out.println("Машина: Двигатель заведен.");
    }

    @Override
    public void drive() {
        System.out.println("Машина: Мчимся по шоссе со скоростью 100 км/ч!");
    }
}
