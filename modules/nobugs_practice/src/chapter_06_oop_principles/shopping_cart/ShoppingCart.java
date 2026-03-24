package chapter_06_oop_principles.shopping_cart;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<Product> items = new ArrayList<>();

    public void addProduct(Product product) {
        items.add(product);
    }

    public void removeProduct(Product product) {
        items.remove(product);
    }

    public double getTotalPrice() {
        double total = 0;
        for (Product product : items) {
            total += product.getPriceProduct();
        }
        return total;
    }
}