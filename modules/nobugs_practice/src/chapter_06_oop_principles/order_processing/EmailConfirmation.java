package chapter_06_oop_principles.order_processing;

public class EmailConfirmation implements OrderProcessor {
    @Override
    public void process(Order order) {
        System.out.printf("[EmailConfirmation] Отправлено подтверждение заказа #%d на email %s\n",
                order.getOrderId(), order.getCustomerEmail());
        order.setConfirmationSent(true);
    }
}