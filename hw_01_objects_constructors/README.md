# Математические операции и утилиты

Проект содержит набор математических методов для выполнения различных вычислений и преобразований.

## Класс MathOperations

### Базовые арифметические операции
- `add(int x, int y)` - сложение двух чисел
- `subtract(int x, int y)` - вычитание двух чисел
- `multiply(int x, int y)` - умножение двух чисел
- `divide(int x, int y)` - деление двух чисел (возвращает double)

### Вспомогательные математические методы
- `findMax(int a, int b)` - нахождение максимального из двух чисел
- `difference(int x, int y)` - модуль разности двух чисел

## Геометрические вычисления
- `squareArea(int side)` - площадь квадрата
- `squarePerimeter(int side)` - периметр квадрата
- `findHypotenuse(double a, double b)` - гипотенуза прямоугольного треугольника
- `circleCircumference(double radius)` - длина окружности

## Конвертация единиц измерения
- `convertSecondsToMinutes(int seconds)` - секунды в минуты
- `averageSpeed(double distance, double time)` - расчет средней скорости
- `calculatePercentage(double total, double part)` - вычисление процентов

## Температурные преобразования
- `celsiusToFahrenheit(double c)` - Цельсий в Фаренгейт
- `fahrenheitToCelsius(double f)` - Фаренгейт в Цельсий

## Особенности реализации
- Все методы статические для удобства использования
- Поддержка различных числовых типов данных
- Математически точные вычисления
- Обработка edge cases (деление на ноль и т.д.)