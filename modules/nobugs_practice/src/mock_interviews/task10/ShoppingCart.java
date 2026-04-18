package mock_interviews.task10;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<CartItem> cartItem;

    public ShoppingCart() {
        cartItem = new ArrayList<CartItem>();
    }

    public void addItem(List<CartItem> CatrItems) {
        for (CartItem item : CatrItems) {
            cartItem.add(item);
        }
    }

    public void removeItem(CartItem item) {
        cartItem.remove(item);
    }

    public void updateQuanity(String name, int newCount) {
        CartItem itemToRemove = null;
        for (CartItem item : cartItem) {
            if (item.getNameProduct().equals(name)) {
                item.setCountProduct(newCount);
                if (item.getCountProduct() <= 0) {
                    itemToRemove = item;

                }
            }
            break;
        }
        if (itemToRemove != null) {
            cartItem.remove(itemToRemove);
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (CartItem item : cartItem) {
            total += item.getPriceProduct() * item.getCountProduct();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Содержимое корзины: " + cartItem.toString() + " | Итого: " + calculateTotal();
    }
}