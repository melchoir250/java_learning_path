---

# Задача: Калькулятор и интерфейс Operation (Стратегия поведения)

## Описание
Создание гибкого калькулятора, который поддерживает разные математические операции. Задача демонстрирует принцип **абстракции** через интерфейс и паттерн "Стратегия" (Strategy Pattern): поведение калькулятора можно менять, подставляя разные реализации операции, не изменяя код самого калькулятора.

## Условие
1.  Создайте **интерфейс** `Operation` с методом `double apply(double a, double b)`.
2.  Реализуйте четыре класса, выполняющих разные операции:
    *   `Addition` — сложение (`a + b`).
    *   `Subtraction` — вычитание (`a - b`).
    *   `Multiplication` — умножение (`a * b`).
    *   `Division` — деление (`a / b`). Обработайте случай деления на ноль (можно выбрасывать исключение или возвращать специальное значение).
3.  Создайте класс **`Calculator`**:
    *   Поле `private Operation operation` (текущая операция).
    *   Конструктор для установки операции.
    *   Метод `void setOperation(Operation operation)` для смены операции.
    *   Метод `double calculate(double a, double b)`, который вызывает метод `apply` текущей операции.
4.  В методе `main` продемонстрируйте работу калькулятора: выполните несколько операций, меняя поведение калькулятора "на лету".

## Пояснение
Интерфейс `Operation` выступает в роли контракта. Класс `Calculator` не знает, какая именно операция будет выполняться (сложение, вычитание и т.д.). Он просто делегирует выполнение методу `apply` текущей операции. Это позволяет легко добавлять новые операции (например, возведение в степень или вычисление остатка) без изменения кода калькулятора — пример **расширяемости** системы.

## Пример кода (структура)

```java
// Интерфейс, определяющий поведение операции
interface Operation {
    double apply(double a, double b);
}

// Конкретные реализации операций
class Addition implements Operation {
    @Override
    public double apply(double a, double b) {
        return a + b;
    }
}

class Subtraction implements Operation {
    @Override
    public double apply(double a, double b) {
        return a - b;
    }
}

class Multiplication implements Operation {
    @Override
    public double apply(double a, double b) {
        return a * b;
    }
}

class Division implements Operation {
    @Override
    public double apply(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Деление на ноль!");
        }
        return a / b;
    }
}

// Класс калькулятора, использующий стратегию (интерфейс Operation)
class Calculator {
    private Operation operation;

    public Calculator(Operation operation) {
        this.operation = operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public double calculate(double a, double b) {
        return operation.apply(a, b); // Делегирование выполнения операции
    }
}

// Демонстрация
public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(new Addition());

        System.out.println("Сложение: " + calculator.calculate(10, 5)); // 15.0

        calculator.setOperation(new Subtraction());
        System.out.println("Вычитание: " + calculator.calculate(10, 5)); // 5.0

        calculator.setOperation(new Multiplication());
        System.out.println("Умножение: " + calculator.calculate(10, 5)); // 50.0

        calculator.setOperation(new Division());
        System.out.println("Деление: " + calculator.calculate(10, 5)); // 2.0
    }
}
```

## Ключевые моменты реализации
*   **Интерфейс как контракт**: `Operation` гарантирует, что у любой операции будет метод `apply`.
*   **Композиция**: Класс `Calculator` содержит ссылку на `Operation` (has-a relationship), а не наследует конкретную операцию.
*   **Полиморфизм**: В методе `calculate` вызывается метод `apply` того объекта, который в данный момент находится в поле `operation`.
*   **Инкапсуляция изменения**: Логика каждой операции изолирована в отдельном классе.

## Ожидаемый результат
Калькулятор выполняет различные арифметические действия. При этом код класса `Calculator` остаётся неизменным независимо от количества поддерживаемых операций. Чтобы добавить новую операцию (например, вычисление процента), достаточно создать новый класс, реализующий интерфейс `Operation`, и передать его в калькулятор через `setOperation()`.
