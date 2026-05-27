package task_07_order_builder;

public class Shop {
    public Order createSimpleOrder() {
        return new OrderBuilder()
                .addItem("Хлеб")
                .addItem("Молоко")
                .setPaymentMethod("Наличные")
                .build();
    }

    public Order createGiftOrder() {
        return new OrderBuilder()
                .addItem("Парфюм")
                .addItem("Открытка")
                .setDiscount(10)
                .setPaymentMethod("Карта")
                .setGiftWrap(true)
                .build();
    }

    public Order createBigOrder() {
        return new OrderBuilder()
                .addItem("Ноутбук")
                .addItem("Мышка")
                .addItem("Клавиатура")
                .addItem("Монитор")
                .setDiscount(15)
                .setPaymentMethod("Кредит")
                .build();
    }
}
