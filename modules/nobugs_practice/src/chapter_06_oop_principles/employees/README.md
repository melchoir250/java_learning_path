---

### 6. Сотрудники с разными ролями (Наследование + Переопределение логики)

```markdown
# Задача 6: Сотрудники с разными ролями

## Описание
Моделирование системы заработной платы для разных типов сотрудников компании. Задача иллюстрирует мощь **наследования** и **полиморфизма**: базовый метод `calculateSalary()` по-разному работает в каждом дочернем классе.

## Условие
1.  Создайте базовый класс `Employee` с методом `double calculateSalary()` (можно возвращать 0 или сделать абстрактным).
2.  Реализуйте трех наследников:
    *   `Manager`: зарплата = `baseSalary + bonus`.
    *   `Developer`: зарплата = `hourlyRate * hoursWorked`.
    *   `Intern`: зарплата = `fixedStipend` (фиксированная стипендия).
3.  Создайте метод `calculateTotalSalary(Employee[] employees)` (или `List<Employee>`), который принимает список всех сотрудников и возвращает общую сумму зарплат к выплате.

## Пояснение
Полиморфизм позволяет нам обрабатывать массив сотрудников разных типов единообразно. Цикл проходит по массиву, и для каждого объекта вызывается его собственная версия метода `calculateSalary()`, что делает код гибким и легко расширяемым.

## Пример кода (структура)
```java
class Employee {
    public double calculateSalary() {
        return 0; // Базовая реализация
    }
}

class Manager extends Employee {
    private double baseSalary, bonus;
    // ...
    @Override
    public double calculateSalary() {
        return baseSalary + bonus;
    }
}

class Developer extends Employee {
    private double hourlyRate, hoursWorked;
    // ...
    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
}

// Демонстрация
public class Main {
    public static double calculateTotalSalary(Employee[] employees) {
        double total = 0;
        for (Employee emp : employees) {
            total += emp.calculateSalary();
        }
        return total;
    }
}