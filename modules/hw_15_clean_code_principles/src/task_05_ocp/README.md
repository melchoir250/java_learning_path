# Задача 5: Исправление нарушения OCP

## Описание проблемы

Исходный код нарушает принцип OCP (Open/Closed Principle):

- Класс закрыт для расширения, но также закрыт для модификации (нужно менять существующий код)
- При добавлении нового способа оплаты необходимо изменять метод `processPayment`
- Добавление каждого нового платежа требует добавления нового `if-else` блока
- Код трудно поддерживать и тестировать

## Исходный код

```java
public class PaymentProcessor {
    public void processPayment(String paymentType, double amount) {
        if (paymentType.equals("CreditCard")) {
            System.out.println("Оплата кредитной картой на сумму " + amount);
        } else if (paymentType.equals("PayPal")) {
            System.out.println("Оплата через PayPal на сумму " + amount);
        } else if (paymentType.equals("Bitcoin")) {
            System.out.println("Оплата Bitcoin на сумму " + amount);
        }
    }
}
```

## Задача

Избавьтесь от `if-else`, применив полиморфизм (наследование или интерфейсы).
