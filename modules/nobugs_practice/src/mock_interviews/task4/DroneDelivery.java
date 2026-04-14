package mock_interviews.task4;

public class DroneDelivery extends DeliveryAbstract {
    public DroneDelivery(String adressDelivery) {
        super(adressDelivery);
    }

    @Override
    public String delivery() {
        return "Дрон летит с посылкой на ул. " + adressDelivery;
    }
}