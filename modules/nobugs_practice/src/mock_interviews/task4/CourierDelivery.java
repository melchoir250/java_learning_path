package mock_interviews.task4;

public class CourierDelivery extends DeliveryAbstract {
    public CourierDelivery(String adressDelivery) {
        super(adressDelivery);
    }

    @Override
    public String delivery() {
        return "Курьер доставляет посылку на ул. " + adressDelivery;
    }
}