---

# Задача 1: Универсальный менеджер сущностей (Entity Manager)

## Описание
Разработайте класс `EntityManager<T>`, который будет управлять коллекцией объектов произвольного типа `T`, обеспечивая потокобезопасное добавление, удаление и получение элементов. Класс также должен предоставлять специфические методы фильтрации данных, которые позволяют пользователю извлекать элементы по определённым критериям.

## Функциональные требования

### 1. Добавление элементов
- Метод для добавления объекта в коллекцию.
- Должен быть **потокобезопасным**.
- Сигнатура: `void add(T entity)`

### 2. Удаление элементов
- Метод для удаления объекта из коллекции.
- Возвращает `true`, если объект был удалён, и `false`, если объект не найден.
- Должен быть **потокобезопасным**.
- Сигнатура: `boolean remove(T entity)`

### 3. Получение всех элементов
- Метод возвращает **копию** списка всех элементов.
- Копирование обеспечивает невозможность изменения исходной коллекции через возвращаемый список.
- Сигнатура: `List<T> getAll()`

### 4. Специализированные методы фильтрации
*Примечание: Для демонстрации этих методов можно использовать конкретный тип, например, `User` с полями `name`, `age`, `isActive`. В этом случае `EntityManager` будет параметризован типом `User`.*

- **Фильтрация по возрасту**: Возвращает список пользователей в заданном возрастном диапазоне.
    - Сигнатура: `List<User> filterByAge(int minAge, int maxAge)`
- **Фильтрация по имени**: Возвращает список пользователей, чьи имена соответствуют заданной строке (можно реализовать полное совпадение, частичное совпадение или регистронезависимый поиск).
    - Сигнатура: `List<User> filterByName(String namePattern)`
- **Фильтрация по активности**: Возвращает список пользователей с заданным статусом активности.
    - Сигнатура: `List<User> filterByActive(boolean isActive)`

## Ключевые темы
- **Дженерики (Generics)**: Обобщённый тип `T` позволяет использовать менеджер с любыми типами объектов.
- **Многопоточность и потокобезопасность**: Обеспечение корректной работы при одновременном доступе из нескольких потоков.
- **Копирование коллекций**: Защита внутренних данных от изменений извне.
- **Фильтрация данных**: Использование Stream API или циклов для выборки элементов по критериям.
- **Тестирование**: Проверка корректности работы всех методов.

## Рекомендации по реализации

### Потокобезопасность
Для обеспечения потокобезопасности можно использовать один из подходов:
- **Синхронизация методов** через ключевое слово `synchronized`.
- **Потокобезопасные коллекции**, например `CopyOnWriteArrayList` или `ConcurrentHashMap` (если нужен поиск по ключу).
- **Явные блокировки** `ReentrantReadWriteLock` для разделения чтения и записи.

### Добавление элементов
```java
public synchronized void add(T entity) {
    // Проверка на null (опционально)
    if (entity == null) {
        throw new IllegalArgumentException("Entity cannot be null");
    }
    entities.add(entity);
}
```

### Удаление элементов
```java
public synchronized boolean remove(T entity) {
    return entities.remove(entity);
}
```

### Возвращение копии списка
```java
public List<T> getAll() {
    synchronized (this) {
        return new ArrayList<>(entities);
    }
}
```

### Фильтрация (пример для User)
```java
public List<User> filterByAge(int minAge, int maxAge) {
    synchronized (this) {
        return entities.stream()
            .filter(user -> user.getAge() >= minAge && user.getAge() <= maxAge)
            .collect(Collectors.toList());
    }
}

public List<User> filterByName(String name) {
    synchronized (this) {
        return entities.stream()
            .filter(user -> user.getName().equalsIgnoreCase(name))
            .collect(Collectors.toList());
    }
}

public List<User> filterByActive(boolean isActive) {
    synchronized (this) {
        return entities.stream()
            .filter(user -> user.isActive() == isActive)
            .collect(Collectors.toList());
    }
}
```

## Тестирование

### Что нужно протестировать

1. **Добавление элементов**:
    - Проверить, что элемент действительно добавляется в коллекцию.
    - Проверить, что добавление работает корректно в многопоточной среде.

2. **Удаление элементов**:
    - Проверить, что существующий элемент удаляется и метод возвращает `true`.
    - Проверить, что при попытке удалить несуществующий элемент метод возвращает `false`.
    - Проверить потокобезопасность удаления.

3. **Получение всех элементов**:
    - Проверить, что возвращается копия, а не оригинальная коллекция.
    - Убедиться, что изменения в возвращённом списке не влияют на внутреннюю коллекцию.

4. **Фильтрация**:
    - Проверить корректность фильтрации по возрасту (граничные значения, пустой результат).
    - Проверить фильтрацию по имени (точное совпадение, регистронезависимость, частичное совпадение).
    - Проверить фильтрацию по активности.

5. **Потокобезопасность**:
    - Создать тест с несколькими потоками, которые одновременно добавляют, удаляют и читают элементы.
    - Проверить отсутствие состояний гонки (race conditions) и повреждения данных.

### Пример теста (JUnit)
```java
@Test
public void testAddAndGetAll() {
    EntityManager<String> manager = new EntityManager<>();
    manager.add("test");
    List<String> all = manager.getAll();
    assertEquals(1, all.size());
    assertEquals("test", all.get(0));
}

@Test
public void testRemoveReturnsFalseForNonExistent() {
    EntityManager<String> manager = new EntityManager<>();
    assertFalse(manager.remove("non-existent"));
}
```

## Пример использования

```java
// Создание менеджера для пользователей
EntityManager<User> userManager = new EntityManager<>();

// Добавление пользователей
userManager.add(new User("Alice", 25, true));
userManager.add(new User("Bob", 30, false));
userManager.add(new User("Charlie", 22, true));

// Получение всех пользователей (копия)
List<User> allUsers = userManager.getAll();

// Фильтрация по возрасту
List<User> youngUsers = userManager.filterByAge(20, 25);

// Фильтрация по имени
List<User> namedUsers = userManager.filterByName("Alice");

// Фильтрация по активности
List<User> activeUsers = userManager.filterByActive(true);

// Удаление пользователя
boolean removed = userManager.remove(alice);
```
