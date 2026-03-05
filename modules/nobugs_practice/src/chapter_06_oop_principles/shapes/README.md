# Задача 5: Фигуры и площадь

## Описание

Создание иерархии геометрических фигур с использованием абстрактного класса для вычисления площади. Задача демонстрирует
принцип абстракции: мы определяем общий метод `getArea()`, но не знаем, как именно он будет реализован в конкретных
фигурах.

## Условие

1. Создайте **абстрактный класс** `Shape` с абстрактным методом `double getArea()`.
2. Создайте三个 (три) класса-наследника:
    * `Circle` (принимает радиус `radius`).
    * `Rectangle` (принимает стороны `width` и `height`).
    * `Triangle` (принимает основание `base` и высоту `height`).
3. В каждом наследнике переопределите метод `getArea()`, реализовав соответствующую математическую формулу.
4. Реализуйте статический метод `printArea(Shape s)`, который принимает любую фигуру (объект типа `Shape`) и выводит её
   площадь в консоль.

## Пояснение

Абстракция позволяет нам работать с разными объектами через единый интерфейс (класс `Shape`). Метод `printArea` не
знает, с какой именно фигурой работает (круг, прямоугольник или треугольник), но он точно знает, что у неё можно вызвать
метод `getArea()`.

## Пример кода (структура)

```java
// Абстрактный класс
abstract class Shape {
    public abstract double getArea();
}

// Класс Круг
class Circle extends Shape {
    private double radius;
    // ... конструктор
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

// Класс Прямоугольник
class Rectangle extends Shape {
    private double width, height;
    // ...
    @Override
    public double getArea() {
        return width * height;
    }
}

// Демонстрация
public class Main {
    public static void printArea(Shape s) {
        System.out.println("Площадь фигуры: " + s.getArea());
    }

    public static void main(String[] args) {
        printArea(new Circle(5));
        printArea(new Rectangle(4, 6));
    }
}