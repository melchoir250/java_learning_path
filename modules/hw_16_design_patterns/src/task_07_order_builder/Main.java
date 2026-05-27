package task_07_order_builder;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop();

        Order simple = shop.createSimpleOrder();
        simple.printInvoice();

        System.out.println();

        Order gift = shop.createGiftOrder();
        gift.printInvoice();

        System.out.println();

        Order big = shop.createBigOrder();
        big.printInvoice();

        System.out.println();

        Order custom = new OrderBuilder()
                .addItem("Книга")
                .addItem("Наушники")
                .setDiscount(5)
                .setPaymentMethod("PayPal")
                .setGiftWrap(true)
                .build();
        custom.printInvoice();
    }
}
