package task_restaurant_menu;

public class HotDish implements Dish {
    private final String dish_name;
    private final int temperature;

    public HotDish(String dish_name, int temperature) {
        this.dish_name = dish_name;
        this.temperature = temperature;
    }

    @Override
    public String getDescription() {
        return dish_name + " (Температура блюда: " + temperature + ")";
    }
}
