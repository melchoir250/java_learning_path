package task_restaurant_menu;

public class Drink implements Dish{
    private final String drink_name;
    private final double volume;

    public Drink(String drink_name, double volume) {
        this.drink_name = drink_name;
        this.volume = volume;
    }

    @Override
    public String getDescription() {
        return drink_name + " (Объем напитка: " + volume + ")";
    }
}
