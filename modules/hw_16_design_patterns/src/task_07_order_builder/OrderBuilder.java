package task_07_order_builder;

import java.util.ArrayList;
import java.util.List;

public class OrderBuilder {
    private final List<String> items = new ArrayList<>();
    private double discount;
    private String paymentMethod = "Наличные";
    private boolean giftWrap;

    public OrderBuilder addItem(String item) {
        items.add(item);
        return this;
    }

    public OrderBuilder setDiscount(double discount) {
        this.discount = discount;
        return this;
    }

    public OrderBuilder setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }

    public OrderBuilder setGiftWrap(boolean giftWrap) {
        this.giftWrap = giftWrap;
        return this;
    }

    public Order build() {
        return new Order(this);
    }

    public List<String> getItems() {
        return items;
    }

    public double getDiscount() {
        return discount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public boolean isGiftWrap() {
        return giftWrap;
    }
}
