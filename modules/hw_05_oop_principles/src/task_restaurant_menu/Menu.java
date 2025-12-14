package task_restaurant_menu;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final List<Dish> dishes = new ArrayList<>();

    public void addDishes(Dish dish) {
        dishes.add(dish);
    }

    public void printMenu() {
        System.out.println("Меню ресторана");
        int count = 1;
        for (Dish dish:dishes) {
            System.out.println(count++ + ". " + dish.getDescription());
        }
    }
}
