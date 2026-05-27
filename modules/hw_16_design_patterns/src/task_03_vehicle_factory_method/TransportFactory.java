package task_03_vehicle_factory_method;

public abstract class TransportFactory {
    public abstract Transport createTransport();

    public void deliverOrder() {
        Transport transport = createTransport();

        transport.startEngine();
        transport.drive();
        System.out.println("Фабрика: Заказ успешно доставлен!");
    }
}
