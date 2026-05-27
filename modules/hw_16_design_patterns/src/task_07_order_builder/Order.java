package task_07_order_builder;

import java.util.List;

public class Order {
    private final List<String> items;
    private final double discount;
    private final String paymentMethod;
    private final boolean isGiftWrap;

    protected Order(OrderBuilder builder) {
        this.items = builder.getItems();
        this.discount = builder.getDiscount();
        this.paymentMethod = builder.getPaymentMethod();
        this.isGiftWrap = builder.isGiftWrap();
    }
    
    public void printInvoice() {
        System.out.println("--- ЧЕК ЗАКАЗА ---");
        System.out.println("Товары в корзине: " + String.join(", ", items));
        System.out.println("Скидка: " + discount + "%");
        System.out.println("Способ оплаты: " + paymentMethod);
        System.out.println("Подарочная упаковка: " + (isGiftWrap ? "Да" : "Нет"));
    }
}