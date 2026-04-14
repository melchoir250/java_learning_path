package mock_interviews.task4;

import java.util.ArrayList;
import java.util.List;

public class DeliveryService {
    private List<Delivery> deliveries = new ArrayList<>();

    public DeliveryService(List<Delivery> deliveries) {
        this.deliveries = deliveries;
    }

    public void deliverySearch() {
        for (Delivery item : deliveries) {
            System.out.println(item.delivery());
        }
    }
}