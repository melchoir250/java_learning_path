package task_03_vehicle_factory_method;

public class Bicycle implements Transport {
    @Override
    public void startEngine() {
        System.out.println("Велосипед: Мотора нет. Проверяем тормоза и поправляем цепь.");
    }

    @Override
    public void drive() {
        System.out.println("Велосипед: Крутим педали, едем по велодорожке.");
    }
}
