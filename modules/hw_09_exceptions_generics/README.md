# 🚀 Домашнее задание: Исключения и дженерики в Java

Проект содержит практические задания по работе с исключениями и дженериками в Java. Каждая задача решена в виде отдельного класса с примерами использования.

## 📁 Структура проекта

```
src/
├── exceptions/
│   ├── FileNotFoundExceptionExample.java    # Задача 1
│   ├── DivisionByZeroExample.java           # Задача 2
│   ├── AgeValidator.java                    # Задача 3
│   │   └── InvalidAgeException.java         # Пользовательское исключение
│   └── EmailValidator.java                  # Задача 4
│       └── InvalidEmailException.java       # Пользовательское исключение
└── generics/
    ├── Box.java                            # Задача 1
    ├── GenericMethods.java                 # Задача 2
    ├── Pair.java                           # Задача 3
    ├── advanced/
    │   ├── Storage.java                    # Доп. задача 1
    │   ├── NumberBox.java                  # Доп. задача 3
    │   ├── Container.java                  # Доп. задача 6
    │   └── MapPrinter.java                 # Доп. задача 7
    └── Main.java                           # Примеры использования
```

## 📚 Задачи на исключения

### 1️⃣ Обработка проверяемого исключения
**Класс:** `FileNotFoundExceptionExample`

```java
// Пример использования
FileNotFoundExceptionExample.readFile("data.txt");
// Вывод: Файл не найден
```

### 2️⃣ Обработка непроверяемого исключения
**Класс:** `DivisionByZeroExample`

```java
// Пример использования
DivisionByZeroExample.divide(10, 2);  // 5.0
DivisionByZeroExample.divide(10, 0);  // Ошибка: Деление на ноль невозможно
```

### 3️⃣ Создание собственного проверяемого исключения
**Классы:** `AgeValidator`, `InvalidAgeException`

```java
// Пример использования
try {
    AgeValidator.validateAge(25);     // OK
    AgeValidator.validateAge(-5);     // ❌ InvalidAgeException
    AgeValidator.validateAge(200);    // ❌ InvalidAgeException
} catch (InvalidAgeException e) {
    System.out.println(e.getMessage());
}
```

### 4️⃣ Создание собственного непроверяемого исключения
**Классы:** `EmailValidator`, `InvalidEmailException`

```java
// Пример использования
EmailValidator.validateEmail("test@example.com");    // OK
EmailValidator.validateEmail("invalid-email");       // ❌ InvalidEmailException
```

## 🔧 Задачи на дженерики

### 1️⃣ Дженерик класс Box
**Класс:** `Box<T>`

```java
// Пример использования
Box<String> stringBox = new Box<>();
stringBox.set("Hello, World!");
System.out.println(stringBox.get());  // Hello, World!

Box<Integer> intBox = new Box<>();
intBox.set(42);
System.out.println(intBox.get());     // 42
```

### 2️⃣ Дженерик метод printArray
**Класс:** `GenericMethods`

```java
// Пример использования
Integer[] intArray = {1, 2, 3, 4, 5};
String[] strArray = {"A", "B", "C"};

GenericMethods.printArray(intArray);  // 1 2 3 4 5
GenericMethods.printArray(strArray);  // A B C
```

### 3️⃣ Дженерик класс Pair
**Класс:** `Pair<T, U>`

```java
// Пример использования
Pair<String, Integer> pair = new Pair<>();
pair.setFirst("Age");
pair.setSecond(25);

System.out.println(pair.getFirst());   // Age
System.out.println(pair.getSecond());  // 25
```

## 🎯 Дополнительные задачи

### 1️⃣ Обобщённый класс Storage
**Класс:** `Storage<T>`
```java
Storage<String> storage = new Storage<>();
storage.set("Some data");
String data = storage.get();
```

### 3️⃣ Работа с числами
**Класс:** `NumberBox<T extends Number>`
```java
NumberBox<Integer> numberBox = new NumberBox<>();
numberBox.add(10);
numberBox.add(20);
numberBox.add(30);
System.out.println(numberBox.getSum());  // 60.0
```

### 6️⃣ Обобщённый интерфейс
**Интерфейс:** `Container<T>`
```java
class SimpleContainer<T> implements Container<T> {
    private T item;
    
    @Override
    public void add(T item) {
        this.item = item;
    }
    
    @Override
    public T get() {
        return item;
    }
}
```

### 7️⃣ Коллекция с обобщёнными типами
**Класс:** `MapPrinter`
```java
Map<String, Integer> map = new HashMap<>();
map.put("One", 1);
map.put("Two", 2);
MapPrinter.printMap(map);
```

## 🛠️ Требования

- Java 8 или выше
- Любая IDE (IntelliJ IDEA, Eclipse, VS Code) или компилятор командной строки

## 📝 Как запустить

1. **Клонируйте репозиторий или скопируйте код**
2. **Компиляция:**
   ```bash
   javac src/exceptions/*.java src/generics/*.java src/generics/advanced/*.java
   ```
3. **Запуск:**
   ```bash
   java -cp src generics.Main
   ```

## 🎓 Чему вы научитесь

✅ Обрабатывать проверяемые и непроверяемые исключения  
✅ Создавать собственные исключения  
✅ Работать с дженериками (классы, методы, интерфейсы)  
✅ Использовать ограничения типов (extends, super)  
✅ Применять дженерики с коллекциями

## 💡 Подсказки

### Для исключений:
- Используйте `try-catch-finally` для обработки исключений
- Проверяемые исключения наследуются от `Exception`
- Непроверяемые исключения наследуются от `RuntimeException`
- Для создания собственных исключений создайте классы, расширяющие соответствующие базовые классы

### Для дженериков:
- Дженерики обеспечивают безопасность типов на этапе компиляции
- Используйте `<T>` для объявления типа-параметра
- Ограничения: `<T extends Number>` (только Number и его подклассы)
- Wildcards: `<? extends T>` и `<? super T>`
