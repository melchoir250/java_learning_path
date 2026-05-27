package task_03_vehicle_factory_method;

public class BicycleFactory extends TransportFactory{
    @Override
    public Transport createTransport() {
        return new Bicycle();
    }
}
