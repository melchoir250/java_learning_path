package task_03_vehicle_factory_method;

public class Main {
    public static void main(String[] args) {
        TransportFactory carFactory = new CarFactory();
        carFactory.deliverOrder();

        TransportFactory bicycleFactory = new BicycleFactory();
        bicycleFactory.deliverOrder();
    }
}