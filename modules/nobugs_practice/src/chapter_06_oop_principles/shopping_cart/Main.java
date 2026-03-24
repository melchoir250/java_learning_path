package chapter_06_oop_principles.shopping_cart;

// 28. Онлайн-магазин с корзиной (Композиция + Инкапсуляция)
//Класс ShoppingCart содержит список товаров.
//Добавление/удаление через методы. Прямой доступ к списку закрыт.
//Методы: addProduct(), removeProduct(), getTotalPrice().
//Пояснение: контроль доступа и управление внутренней структурой.

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> allItem = List.of(
                new Product("Phone", 990),
                new Product("Headphone", 200),
                new Product("Case", 20)
        );
        ShoppingCart shoppingCart = new ShoppingCart();
        for (Product product : allItem) {
            shoppingCart.addProduct(product);
        }
        System.out.println(shoppingCart.getTotalPrice());
    }
}