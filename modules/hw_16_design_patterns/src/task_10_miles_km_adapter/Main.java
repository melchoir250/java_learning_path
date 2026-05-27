package task_10_miles_km_adapter;

public class Main {
    public static void main(String[] args) {
        NavigationSystem navigation = new NavigationSystem();

        Distance routeInKm = new Kilometers(50);
        navigation.planRoute(routeInKm);

        Miles oldDistance = new Miles(10);
        System.out.println("Старая система хранит: " + oldDistance.getValue() + " " + oldDistance.getUnit());

        Distance adapted = new MilesToKilometersAdapter(oldDistance);
        System.out.println("После адаптера: " + adapted.getValue() + " " + adapted.getUnit());
        navigation.planRoute(adapted);
    }
}
