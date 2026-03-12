---

# Задача 5: Возраст не увеличивается

## Описание
Программа должна увеличить возраст человека на 1, но после вызова метода `updateAge` возраст остаётся прежним. Ваша задача — с помощью отладчика найти причину ошибки и исправить код.

## Условие
```java
public class DebugTask5 {
    public static void main(String[] args) {
        Person person = new Person("Alice", 25);
        updateAge(person);
        System.out.println("Updated age: " + person.getAge());
    }
    
    public static void updateAge(Person person) {
        person = new Person(person.getName(), person.getAge() + 1);
    }
}

class Person {
    private String name;
    private int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() { return name; }
    public int getAge() { return age; }
}
```

## Ожидаемый результат
Программа должна вывести возраст, увеличенный на 1:
```
Updated age: 26
```

## Фактическое поведение
При запуске программа выводит исходный возраст:
```
Updated age: 25
```

## Задание
1. Запустите программу в режиме отладки (Debug).
2. Установите точку останова (breakpoint) в начале метода `updateAge`.
3. Проанализируйте значения переменных и ссылок на каждом шаге выполнения.
4. Найдите причину, по которой возраст не изменяется.
5. Исправьте код так, чтобы он работал согласно ожиданию.
6. Запишите процесс отладки и исправления на видео.

## Подсказки для отладки
- Обратите внимание на то, что происходит с переданной ссылкой внутри метода.
- Проследите, создаётся ли новый объект и что происходит со старым.
- Проверьте, изменяется ли исходный объект или только локальная ссылка.