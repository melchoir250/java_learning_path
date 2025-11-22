package chapter_02_classes_objects;

public class ShopItem {
    double price;
    int discount;

    ShopItem(double somePrice, int someDiscount) {
        this.price = somePrice;
        this.discount = someDiscount;
    }

    double getFinalPrice() {
        return this.price * (100 - this.discount) / 100;
    }

    public static void main(String[] args) {
        ShopItem shop1 = new ShopItem(100, 20);
        ShopItem shop2 = new ShopItem(130, 7);
        System.out.println(shop1.getFinalPrice());
        System.out.println(shop2.getFinalPrice());
    }
}
