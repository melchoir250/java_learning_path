package product;

public class Product {
    String name;
    int price;

    Product(String someName, int somePrice) {
        this.name = someName;
        this.price = somePrice;
    }

    int getPrice() {

        return this.price;
    }

    void setPrice(int newPrice) {

        this.price = newPrice;
    }

    void applyDiscount(int discount) {

        this.price -= discount;
    }

    void printInfo() {

        System.out.println("Информация о товаре: " + this.name + ", цена товара: " + getPrice());
    }
}
