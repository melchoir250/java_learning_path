# Задача 2: Исправление нарушения KISS

## Описание проблемы

Исходный код нарушает принцип KISS (Keep It Simple, Stupid):

- Слишком сложная вложенная логика с условиями
- Трудно читать и понимать логику расчёта скидки
- При добавлении новых правил скидки код станет ещё сложнее

## Исходный код

```java
public class DiscountCalculator {
    public double calculateDiscount(double price, boolean isLoyalCustomer, boolean isFirstPurchase, boolean hasCoupon) {
        double discount = 0.0;

        if (isLoyalCustomer) {
            if (isFirstPurchase) {
                discount = price * 0.10;
            } else {
                discount = price * 0.05;
            }
        } else {
            if (hasCoupon) {
                discount = price * 0.07;
            } else {
                discount = price * 0.02;
            }
        }
        return price - discount;
    }
}
```

## Задача

Упростите код, убрав вложенные условия, сделав его более читаемым и поддерживаемым.

## Требования

- Избавиться от вложенных условий
- Сделать логику расчёта скидки понятной и прозрачной
- Можно использовать отдельные методы для расчёта процентной ставки
- Результат должен совпадать с исходным
