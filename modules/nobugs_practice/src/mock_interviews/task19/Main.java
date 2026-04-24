package mock_interviews.task19;

public class Main {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();

        warehouse.addProduct("Apple", 10);
        warehouse.addProduct("Banana", 5);
        warehouse.addProduct("Apple", 3);

        System.out.println("Apple: " + warehouse.getBalance("Apple"));
        System.out.println("Banana: " + warehouse.getBalance("Banana"));

        warehouse.removeProduct("Banana", 2);
        System.out.println("Остаток Banana: " + warehouse.getBalance("Banana"));

        warehouse.removeProduct("Apple", 20);
        warehouse.removeProduct("Orange", 1);
    }
}