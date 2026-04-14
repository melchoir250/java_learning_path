package mock_interviews.task4;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CourierDelivery courierDelivery1 = new CourierDelivery("Красная 55");
        CourierDelivery courierDelivery2 = new CourierDelivery("Красная 25");
        CourierDelivery courierDelivery3 = new CourierDelivery("Красная 15");

        DroneDelivery droneDelivery1 = new DroneDelivery("Мира 88");
        DroneDelivery droneDelivery2 = new DroneDelivery("Мира 7");
        DroneDelivery droneDelivery3 = new DroneDelivery("Мира 28");

        PostDelivery postDelivery1 = new PostDelivery("Октябрьская 22");
        PostDelivery postDelivery2 = new PostDelivery("Октябрьская 11");
        PostDelivery postDelivery3 = new PostDelivery("Октябрьская 55");

        DeliveryService deliveryServiceList = new DeliveryService(List.of(
                courierDelivery1,
                courierDelivery2,
                courierDelivery3,
                droneDelivery1,
                droneDelivery2,
                droneDelivery3,
                postDelivery1,
                postDelivery2,
                postDelivery3
        ));

        deliveryServiceList.deliverySearch();
    }
}