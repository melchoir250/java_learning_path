package chapter_06_oop_principles.delivery_strategy;

public class Main {
    public static void main(String[] args) {
        Courier courier = new Courier();
        Drone drone = new Drone();
        Pickup pickup = new Pickup();
        double distance = 10.0;
        DeliveryService deliveryService = new DeliveryService(courier);
        System.out.println(deliveryService.getDeliveryStrategy() + deliveryService.calculate(distance));
        deliveryService.setDeliveryStrategy(drone);
        System.out.println(deliveryService.getDeliveryStrategy() + deliveryService.calculate(distance));
        deliveryService.setDeliveryStrategy(pickup);
        System.out.println(deliveryService.getDeliveryStrategy() + deliveryService.calculate(distance));
    }
}