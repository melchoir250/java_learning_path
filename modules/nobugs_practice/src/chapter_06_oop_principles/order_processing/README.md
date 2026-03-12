---

# Задача: Обработка заказов (Интерфейс + Расширяемость)

## Описание
Создание гибкой системы обработки заказов, состоящей из цепочки независимых обработчиков. Задача демонстрирует **принцип открытости/закрытости** (Open/Closed Principle): система открыта для расширения (можно добавлять новые обработчики), но закрыта для изменения (существующий код не требует правок). Это классический пример паттерна "Цепочка обязанностей" (Chain of Responsibility) в упрощённом виде.

## Условие
1.  Создайте класс **`Order`** (заказ):
    *   Поля: `int orderId`, `String customerEmail`, `double totalAmount`, `boolean inventoryUpdated`, `boolean confirmationSent`, `int loyaltyPointsAdded` (или другие флаги состояния).
    *   Конструктор, геттеры и сеттеры.
2.  Создайте **интерфейс** `OrderProcessor` с методом `void process(Order order)`.
3.  Реализуйте три класса-обработчика, каждый выполняет свою задачу:
    *   **`EmailConfirmation`** — отправляет подтверждение на email клиента (выводит в консоль: `"Отправлено подтверждение заказа #... на email ..."`).
    *   **`InventoryUpdate`** — обновляет складские остатки (списывает товары). Вывод: `"Склад обновлён для заказа #... Списано товаров на сумму ..."`.
    *   **`LoyaltyPointsAdder`** — начисляет бонусные баллы клиенту (например, 1% от суммы заказа). Вывод: `"Начислено ... бонусных баллов за заказ #..."`.
4.  Создайте класс **`OrderProcessingPipeline`** (конвейер обработки):
    *   Поле `private List<OrderProcessor> processors`.
    *   Метод `void addProcessor(OrderProcessor processor)` — добавляет обработчик в конвейер.
    *   Метод `void removeProcessor(OrderProcessor processor)` — удаляет обработчик (по желанию).
    *   Метод `void processOrder(Order order)` — проходит по всем обработчикам и вызывает у каждого `process(order)`.
5.  В методе `main` продемонстрируйте:
    *   Создание заказа.
    *   Создание конвейера с разными наборами обработчиков.
    *   Обработку заказа через конвейер.
    *   Добавление нового обработчика "на лету" и повторную обработку (или обработку другого заказа).

## Пояснение
Интерфейс `OrderProcessor` определяет контракт для всех обработчиков. Класс `OrderProcessingPipeline` ничего не знает о конкретных реализациях — он просто хранит список процессоров и вызывает у каждого метод `process()`. Это позволяет легко добавлять новые обработчики (например, `SmsNotifier` или `InvoiceGenerator`) без изменения существующего кода конвейера или других обработчиков. Система становится гибкой и расширяемой.

## Пример кода (структура)

```java
import java.util.ArrayList;
import java.util.List;

// Класс Заказа
class Order {
    private int orderId;
    private String customerEmail;
    private double totalAmount;
    private boolean inventoryUpdated;
    private boolean confirmationSent;
    private int loyaltyPoints;
    
    public Order(int orderId, String customerEmail, double totalAmount) {
        this.orderId = orderId;
        this.customerEmail = customerEmail;
        this.totalAmount = totalAmount;
    }
    
    // Геттеры и сеттеры
    public int getOrderId() { return orderId; }
    public String getCustomerEmail() { return customerEmail; }
    public double getTotalAmount() { return totalAmount; }
    
    public boolean isInventoryUpdated() { return inventoryUpdated; }
    public void setInventoryUpdated(boolean inventoryUpdated) { 
        this.inventoryUpdated = inventoryUpdated; 
    }
    
    public boolean isConfirmationSent() { return confirmationSent; }
    public void setConfirmationSent(boolean confirmationSent) { 
        this.confirmationSent = confirmationSent; 
    }
    
    public int getLoyaltyPoints() { return loyaltyPoints; }
    public void setLoyaltyPoints(int loyaltyPoints) { 
        this.loyaltyPoints = loyaltyPoints; 
    }
}

// Интерфейс обработчика заказов
interface OrderProcessor {
    void process(Order order);
}

// Обработчик: отправка email-подтверждения
class EmailConfirmation implements OrderProcessor {
    @Override
    public void process(Order order) {
        // Имитация отправки email
        System.out.printf("[EmailConfirmation] Отправлено подтверждение заказа #%d на email %s\n",
                order.getOrderId(), order.getCustomerEmail());
        order.setConfirmationSent(true);
    }
}

// Обработчик: обновление склада
class InventoryUpdate implements OrderProcessor {
    @Override
    public void process(Order order) {
        // Имитация списания товаров со склада
        System.out.printf("[InventoryUpdate] Склад обновлён для заказа #%d. Списано товаров на сумму $%.2f\n",
                order.getOrderId(), order.getTotalAmount());
        order.setInventoryUpdated(true);
    }
}

// Обработчик: начисление бонусных баллов
class LoyaltyPointsAdder implements OrderProcessor {
    private static final double POINTS_PERCENTAGE = 0.01; // 1% от суммы
    
    @Override
    public void process(Order order) {
        int points = (int)(order.getTotalAmount() * POINTS_PERCENTAGE);
        System.out.printf("[LoyaltyPointsAdder] Начислено %d бонусных баллов за заказ #%d\n",
                points, order.getOrderId());
        order.setLoyaltyPoints(points);
    }
}

// Конвейер обработки заказов
class OrderProcessingPipeline {
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

// Демонстрация
public class Main {
    public static void main(String[] args) {
        // Создаём заказы
        Order order1 = new Order(1001, "ivan@example.com", 250.75);
        Order order2 = new Order(1002, "maria@example.com", 520.50);
        
        // Создаём конвейер
        OrderProcessingPipeline pipeline = new OrderProcessingPipeline();
        
        // Добавляем базовые обработчики
        pipeline.addProcessor(new EmailConfirmation());
        pipeline.addProcessor(new InventoryUpdate());
        
        // Обрабатываем первый заказ
        pipeline.processOrder(order1);
        
        // Добавляем ещё один обработчик (начисление баллов)
        pipeline.addProcessor(new LoyaltyPointsAdder());
        
        // Обрабатываем второй заказ с обновлённым конвейером
        pipeline.processOrder(order2);
        
        // Проверяем состояние заказов
        System.out.println("=== Состояние заказов после обработки ===");
        System.out.printf("Заказ #%d: подтверждение=%s, склад=%s, баллы=%d\n",
                order1.getOrderId(),
                order1.isConfirmationSent(),
                order1.isInventoryUpdated(),
                order1.getLoyaltyPoints());
        
        System.out.printf("Заказ #%d: подтверждение=%s, склад=%s, баллы=%d\n",
                order2.getOrderId(),
                order2.isConfirmationSent(),
                order2.isInventoryUpdated(),
                order2.getLoyaltyPoints());
    }
}
```

## Ключевые моменты реализации

*   **Интерфейс как контракт**: `OrderProcessor` гарантирует, что любой обработчик имеет метод `process(Order order)`.
*   **Композиция обработчиков**: `OrderProcessingPipeline` содержит список процессоров и управляет ими.
*   **Открытость/закрытость**: Чтобы добавить новую функциональность (например, SMS-уведомление), нужно просто создать новый класс, реализующий `OrderProcessor`, и добавить его в конвейер. Никакой существующий код не меняется.
*   **Единообразная обработка**: Конвейер не знает и не хочет знать, что конкретно делает каждый процессор. Он просто вызывает `process()` для всех по порядку.
*   **Состояние заказа**: Каждый обработчик может читать и изменять состояние заказа, передавая информацию дальше по цепочке.

## Ожидаемый результат

При запуске программы мы увидим, как конвейер динамически меняется, и разные заказы обрабатываются разным набором процессоров:

```
Добавлен обработчик: EmailConfirmation
Добавлен обработчик: InventoryUpdate

--- Начало обработки заказа #1001 ---
[EmailConfirmation] Отправлено подтверждение заказа #1001 на email ivan@example.com
[InventoryUpdate] Склад обновлён для заказа #1001. Списано товаров на сумму $250.75
--- Завершение обработки заказа #1001 ---

Добавлен обработчик: LoyaltyPointsAdder

--- Начало обработки заказа #1002 ---
[EmailConfirmation] Отправлено подтверждение заказа #1002 на email maria@example.com
[InventoryUpdate] Склад обновлён для заказа #1002. Списано товаров на сумму $520.50
[LoyaltyPointsAdder] Начислено 5 бонусных баллов за заказ #1002
--- Завершение обработки заказа #1002 ---

=== Состояние заказов после обработки ===
Заказ #1001: подтверждение=true, склад=true, баллы=0
Заказ #1002: подтверждение=true, склад=true, баллы=5
```
