package mock_interviews.task21;

public class Main {
    public static void main(String[] args) {
        Inventory playerInventory = new Inventory();

        playerInventory.addItem("Potion", 3);
        playerInventory.addItem("Arrow", 10);
        playerInventory.addItem("Potion", 2);

        System.out.println("Potion: " + playerInventory.getAmount("Potion"));
        System.out.println("Arrow: " + playerInventory.getAmount("Arrow"));

        playerInventory.useItem("Potion");
        System.out.println("Количество Potion теперь: " + playerInventory.getAmount("Potion"));

        playerInventory.addItem("Sword", 1);
        playerInventory.useItem("Sword");
        System.out.println("Есть ли Sword в инвентаре? " + playerInventory.hasItem("Sword"));
    }
}