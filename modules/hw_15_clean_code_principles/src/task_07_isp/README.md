# Задача 7: Исправление нарушения ISP

## Описание проблемы

Исходный код нарушает принцип ISP (Interface Segregation Principle):

- Интерфейс `Worker` содержит два метода: `work()` и `eat()`
- Класс `Programmer` вынужден реализовывать метод `eat()`, который ему не нужен
- Метод `eat()` выбрасывает исключение, что является признаком плохого дизайна
- Клиенты зависят от методов, которые не используют

## Исходный код

```java
interface Worker {
    void work();

    void eat();
}

class Programmer implements Worker {
    @Override
    public void work() {
        System.out.println("Программист пишет код");
    }

    @Override
    public void eat() {
        throw new UnsupportedOperationException("Программист не ест на работе");
    }
}
```

## Задача

Разделите интерфейс на отдельные специализированные интерфейсы.
