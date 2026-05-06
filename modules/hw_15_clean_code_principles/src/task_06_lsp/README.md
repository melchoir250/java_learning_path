# Задача 6: Исправление нарушения LSP

## Описание проблемы

Исходный код нарушает принцип LSP (Liskov Substitution Principle):

- Подкласс `Penguin` не может заменить базовый класс `Bird`
- Метод `fly()` в классе `Penguin` выбрасывает исключение, чего нет в базовом классе
- Код, использующий `Bird`, сломается при передаче `Penguin`
- Наследование используется там, где оно не должно применяться

## Исходный код

```java
class Bird {
    public void fly() {
        System.out.println("Птица летит");
    }
}

class Penguin extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Пингвины не летают");
    }
}
```

## Задача

Перепроектируйте код так, чтобы классы-наследники не нарушали поведение базового класса.
