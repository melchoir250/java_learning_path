package mock_interviews.task10;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CartItem phone = new CartItem("Phone", 999.99, 3);
        CartItem laptop = new CartItem("Laptop", 1500.00, 1);
        CartItem headphones = new CartItem("Headphones", 199.99, 2);
        CartItem mouse = new CartItem("Mouse", 49.99, 5);
        CartItem keyboard = new CartItem("Keyboard", 129.99, 2);

        List<CartItem> itemsCart = List.of(phone, laptop, headphones, mouse, keyboard);

        ShoppingCart cart = new ShoppingCart();
        cart.addItem(itemsCart);
        System.out.println(cart);
    }
}