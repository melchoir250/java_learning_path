package mock_interviews.task4;

public abstract class DeliveryAbstract implements Delivery {
    protected String adressDelivery;

    public DeliveryAbstract(String adressDelivery) {
        this.adressDelivery = adressDelivery;
    }

    public String getAdressDelivery() {
        return adressDelivery;
    }

    public void setAdressDelivery(String adressDelivery) {
        this.adressDelivery = adressDelivery;
    }
}