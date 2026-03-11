---

# Задача: Счётчики через наследование (Переиспользование логики)

## Описание
Разработка семейства счётчиков на основе базового класса. Задача демонстрирует ключевую идею наследования: создание общего функционала в родительском классе и его расширение/изменение в дочерних классах без дублирования кода.

## Условие
1.  Создайте **базовый класс** `Counter`:
    *   Поле `protected int value` (текущее значение).
    *   Конструктор для инициализации начального значения.
    *   Метод `void increment()` — увеличивает значение на 1.
    *   Метод `int getValue()` — возвращает текущее значение.
2.  Создайте класс-наследник **`StepCounter`**:
    *   Добавляет поле `private int step` (шаг увеличения).
    *   Переопределяет метод `increment()` так, чтобы значение увеличивалось не на 1, а на заданный шаг.
3.  Создайте класс-наследник **`LimitedCounter`**:
    *   Добавляет поле `private int maxValue` (максимально допустимое значение).
    *   Переопределяет метод `increment()` так, чтобы значение не превышало установленный максимум (если после увеличения значение станет больше `maxValue`, то значение либо не меняется, либо устанавливается равным `maxValue`).
4.  В методе `main` продемонстрируйте работу всех трёх типов счётчиков.

## Пояснение
Наследование позволяет нам **переиспользовать** общую логику хранения значения и метода `getValue()` из класса `Counter`. Мы не пишем этот код заново в `StepCounter` и `LimitedCounter`, а только добавляем новую функциональность (поле `step`, поле `maxValue`) и **изменяем** (переопределяем) поведение метода `increment()`. Это экономит время и делает код более поддерживаемым.

## Пример кода (структура)
```java
// Базовый класс с общей логикой
class Counter {
    protected int value;

    public Counter(int initialValue) {
        this.value = initialValue;
    }

    public void increment() {
        value++; // Увеличение на 1
    }

    public int getValue() {
        return value;
    }
}

// Счётчик с шагом (переопределяем логику increment)
class StepCounter extends Counter {
    private int step;

    public StepCounter(int initialValue, int step) {
        super(initialValue); // Вызов конструктора родителя
        this.step = step;
    }

    @Override
    public void increment() {
        value += step; // Увеличение на заданный шаг
    }
}

// Счётчик с ограничением (переопределяем логику increment)
class LimitedCounter extends Counter {
    private int maxValue;

    public LimitedCounter(int initialValue, int maxValue) {
        super(initialValue);
        this.maxValue = maxValue;
    }

    @Override
    public void increment() {
        if (value < maxValue) {
            value++; // Увеличиваем, только если не достигли максимума
        }
    }
}

// Демонстрация
public class Main {
    public static void main(String[] args) {
        Counter regular = new Counter(0);
        StepCounter stepCounter = new StepCounter(0, 5);
        LimitedCounter limitedCounter = new LimitedCounter(7, 10);

        regular.increment(); // стало 1
        stepCounter.increment(); // стало 5
        limitedCounter.increment(); // стало 8
        limitedCounter.increment(); // стало 9
        limitedCounter.increment(); // стало 10
        limitedCounter.increment(); // осталось 10 (не увеличивается)

        System.out.println("Обычный: " + regular.getValue());       // 1
        System.out.println("Шаговый: " + stepCounter.getValue());   // 5
        System.out.println("Лимитный: " + limitedCounter.getValue()); // 10
    }
}
```

## Ключевые моменты реализации
*   **`protected`-доступ**: Поле `value` в базовом классе объявлено как `protected`, чтобы дочерние классы могли напрямую к нему обращаться.
*   **Вызов конструктора родителя (`super`)**: В конструкторах наследников обязательно вызывается конструктор базового класса для инициализации общей части состояния.
*   **Переопределение (`@Override`)**: Метод `increment()` переопределяется для изменения стандартного поведения.

## Ожидаемый результат
При запуске программы мы увидим, что все три счётчика работают по-разному, но при этом используют общую инфраструктуру (метод `getValue()`, хранение состояния), унаследованную от класса `Counter`. Код не дублируется, а расширяется.