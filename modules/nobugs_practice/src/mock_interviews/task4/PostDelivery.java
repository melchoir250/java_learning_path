package mock_interviews.task4;

public class PostDelivery extends DeliveryAbstract {
    public PostDelivery(String adressDelivery) {
        super(adressDelivery);
    }

    @Override
    public String delivery() {
        return "Почта отправила посылку через сортировочный центр на ул. " + adressDelivery;
    }
}