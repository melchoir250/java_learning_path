package mock_interviews.task8;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Order order = new Order(1);
        Product productApple = new Product("Apple", 123.1, 2);
        Product productPear = new Product("Pear", 148.4, 4);
        Product productTomato = new Product("Tomato", 236.1, 3);

        order.addProduct(productApple);
        order.addProduct(productPear);
        order.addProduct(productTomato);

        order.calculateTotal();
        System.out.println(order.calculateTotal());
    }
}