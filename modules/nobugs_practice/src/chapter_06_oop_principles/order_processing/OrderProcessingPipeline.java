package chapter_06_oop_principles.order_processing;

import java.util.ArrayList;
import java.util.List;

public class OrderProcessingPipeline {
    private List<OrderProcessor> processors = new ArrayList<>();

    public void addProcessor(OrderProcessor processor) {
        processors.add(processor);
        System.out.println("Добавлен обработчик: " + processor.getClass().getSimpleName());
    }

    public void removeProcessor(OrderProcessor processor) {
        processors.remove(processor);
        System.out.println("Удалён обработчик: " + processor.getClass().getSimpleName());
    }

    public void processOrder(Order order) {
        System.out.println("\n--- Начало обработки заказа #" + order.getOrderId() + " ---");
        for (OrderProcessor processor : processors) {
            processor.process(order);
        }
        System.out.println("--- Завершение обработки заказа #" + order.getOrderId() + " ---\n");
    }
}
