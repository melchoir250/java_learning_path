package chapter_06_oop_principles.comparable_product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();

        products.add(new Product("Apple", 100));
        products.add(new Product("Banana", 50));
        products.add(new Product("Orange", 100));
        products.add(new Product("Kiwi", 75));

        Collections.sort(products);

        for (Product p : products) {
            System.out.println(p);
        }
    }
}