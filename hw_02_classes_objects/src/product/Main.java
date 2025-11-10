package product;

public class Main {
    public static void main(String[] args) {
        Product bread = new Product("Хлеб", 100);
        bread.printInfo();
        bread.setPrice(30);
        bread.printInfo();
        bread.applyDiscount(5);
        bread.printInfo();

        Product milk = new Product("Молоко", 300);
        milk.printInfo();
        milk.setPrice(80);
        milk.printInfo();
        milk.applyDiscount(15);
        milk.printInfo();
    }
}
