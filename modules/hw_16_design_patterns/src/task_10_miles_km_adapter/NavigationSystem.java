package task_10_miles_km_adapter;

public class NavigationSystem {

    public void planRoute(Distance distance) {
        if (!"km".equals(distance.getUnit())) {
            throw new IllegalArgumentException(
                    "Навигация работает только с километрами, получено: " + distance.getUnit()
            );
        }
        System.out.println("Маршрут построен на " + distance.getValue() + " " + distance.getUnit());
    }
}
