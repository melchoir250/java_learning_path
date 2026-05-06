package task_04_srp;

public class InvoiceService {
    public void generate(Order order) {
        System.out.println("Генерируем счет для заказа " + order.getOrderId());
    }
}