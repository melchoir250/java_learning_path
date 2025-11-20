package laptop;

public class Main {
    public static void main(String[] args) {
        Laptop lenovo = new Laptop("Lenovo", 1000);
        lenovo.printInfo();
        lenovo.setBrand("Asus");
        lenovo.setPrice(800);
        lenovo.printInfo();

        Laptop apple = new Laptop("Apple", 3000);
        apple.printInfo();
        apple.setPrice(900);
        apple.setBrand("Apple MacBookAir");
        apple.printInfo();
    }
}
