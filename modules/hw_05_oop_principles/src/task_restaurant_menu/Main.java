package task_restaurant_menu;

public class Main {
    public static void main(String[] args) {
        Menu rest = new Menu();

        Dish soup = new HotDish("Суп", 55);
        rest.addDishes(soup);

        Dish cola = new Drink("Coca-Cola", 0.5);
        rest.addDishes(cola);

        Dish potato_fri = new HotDish("Картофель Фри", 50);
        rest.addDishes(potato_fri);

        rest.printMenu();
    }
}
