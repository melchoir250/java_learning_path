---

# Задача 5: Инвентарь склада (Inventory Management)

## Описание
Разработайте систему для управления складом, которая позволяет добавлять и извлекать товары различных типов. Система должна управлять доступом к складу через переменную `isInventoryOpen` и обрабатывать ситуации, когда товары заканчиваются, выбрасывая исключение `OutOfStockException`.

## Ключевые темы
- **Коллекции**: `Map<String, List<Product>>` для хранения товаров по категориям
- **Управление состоянием**: флаг `isInventoryOpen`
- **Пользовательские исключения**: `OutOfStockException`
- **Stream API** для поиска и фильтрации товаров
- **Лямбда-выражения** для фильтрации по цене
- **Тестирование** всех сценариев

---

## Классы и интерфейсы

### Класс `Product`
Базовый класс товара с минимальными характеристиками.

```java
public class Product {
    private final String name;
    private final double price;
    private final String category;
    
    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
    
    // Геттеры
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public String getCategory() {
        return category;
    }
    
    @Override
    public String toString() {
        return String.format("Product{name='%s', price=%.2f, category='%s'}", 
                name, price, category);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 &&
               Objects.equals(name, product.name) &&
               Objects.equals(category, product.category);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name, price, category);
    }
}
```

### Исключение `OutOfStockException`
Специализированное исключение для ситуаций, когда товар отсутствует на складе.

```java
public class OutOfStockException extends Exception {
    public OutOfStockException(String message) {
        super(message);
    }
    
    public OutOfStockException(String message, Throwable cause) {
        super(message, cause);
    }
}
```

### Класс `InventoryService`
Сервис для управления товарами на складе.

```java
public class InventoryService {
    private final Map<String, List<Product>> inventory;
    private boolean isInventoryOpen;
    
    public InventoryService() {
        this(true); // По умолчанию склад открыт
    }
    
    public InventoryService(boolean isInventoryOpen) {
        this.inventory = new ConcurrentHashMap<>();
        this.isInventoryOpen = isInventoryOpen;
    }
    
    // Геттеры и сеттеры для флага
    public boolean isInventoryOpen() {
        return isInventoryOpen;
    }
    
    public void setInventoryOpen(boolean inventoryOpen) {
        isInventoryOpen = inventoryOpen;
    }
    
    // Основные методы будут реализованы ниже
}
```

---

## Функциональные требования

### 1. Хранение товаров
- Используйте `Map<String, List<Product>>` для хранения товаров.
- Ключ — категория товара (строка).
- Значение — список продуктов в этой категории.
- Рекомендуется использовать потокобезопасную реализацию, например `ConcurrentHashMap`.

### 2. Управление доступом к складу
- Флаг `isInventoryOpen` определяет, доступен ли склад для операций.
- Если `isInventoryOpen == false`, добавление товаров не должно выполняться.
- Можно также контролировать операции извлечения (по желанию).

### 3. Добавление товара
- Метод для добавления товара на склад.
- Если флаг `isInventoryOpen == false`, операция не выполняется (можно возвращать `false` или ничего не делать).
- Товар добавляется в список соответствующей категории.

```java
public boolean addProduct(Product product) {
    if (!isInventoryOpen) {
        System.out.println("Склад закрыт. Товар не добавлен: " + product);
        return false;
    }
    
    if (product == null) {
        throw new IllegalArgumentException("Product cannot be null");
    }
    
    inventory.computeIfAbsent(product.getCategory(), k -> new CopyOnWriteArrayList<>())
             .add(product);
    
    System.out.println("Товар добавлен на склад: " + product);
    return true;
}
```

### 4. Извлечение товара по категории
- Метод для получения списка товаров по категории.
- Если в указанной категории нет товаров, выбрасывается исключение `OutOfStockException`.
- Можно возвращать копию списка для защиты от изменений.

```java
public List<Product> getProductsByCategory(String category) throws OutOfStockException {
    List<Product> products = inventory.get(category);
    
    if (products == null || products.isEmpty()) {
        throw new OutOfStockException("No products in category: " + category);
    }
    
    return new ArrayList<>(products); // Возвращаем копию
}

// Вариант с извлечением и удалением одного товара
public Product takeProduct(String category) throws OutOfStockException {
    List<Product> products = inventory.get(category);
    
    if (products == null || products.isEmpty()) {
        throw new OutOfStockException("No products available in category: " + category);
    }
    
    // Удаляем первый товар из списка (FIFO)
    return products.remove(0);
}
```

### 5. Фильтрация товаров по цене
- Использование **Stream API** и **лямбда-выражений** для фильтрации.
- Метод возвращает товары из указанной категории с ценой в заданном диапазоне.

```java
public List<Product> filterProductsByPrice(String category, double minPrice, double maxPrice) 
        throws OutOfStockException {
    
    List<Product> products = getProductsByCategory(category);
    
    return products.stream()
            .filter(p -> p.getPrice() >= minPrice && p.getPrice() <= maxPrice)
            .collect(Collectors.toList());
}

// Фильтрация по минимальной цене
public List<Product> filterProductsByMinPrice(String category, double minPrice) 
        throws OutOfStockException {
    
    List<Product> products = getProductsByCategory(category);
    
    return products.stream()
            .filter(p -> p.getPrice() >= minPrice)
            .collect(Collectors.toList());
}

// Фильтрация по максимальной цене
public List<Product> filterProductsByMaxPrice(String category, double maxPrice) 
        throws OutOfStockException {
    
    List<Product> products = getProductsByCategory(category);
    
    return products.stream()
            .filter(p -> p.getPrice() <= maxPrice)
            .collect(Collectors.toList());
}
```

### 6. Дополнительные полезные методы

```java
// Получить все категории товаров
public Set<String> getAllCategories() {
    return inventory.keySet();
}

// Получить количество товаров в категории
public int getProductCount(String category) {
    List<Product> products = inventory.get(category);
    return products == null ? 0 : products.size();
}

// Проверить наличие товаров в категории
public boolean hasProducts(String category) {
    List<Product> products = inventory.get(category);
    return products != null && !products.isEmpty();
}

// Получить общее количество товаров на складе
public int getTotalProductCount() {
    return inventory.values().stream()
            .mapToInt(List::size)
            .sum();
}

// Поиск товара по названию (во всех категориях)
public List<Product> searchProductByName(String name) {
    return inventory.values().stream()
            .flatMap(List::stream)
            .filter(p -> p.getName().toLowerCase().contains(name.toLowerCase()))
            .collect(Collectors.toList());
}
```

---

## Рекомендации по реализации

### 1. Потокобезопасность
Для обеспечения потокобезопасности можно использовать:
- **`ConcurrentHashMap`** для хранения товаров
- **`CopyOnWriteArrayList`** для списков товаров (если чтение преобладает)
- **Синхронизацию** через `synchronized` для критических секций

```java
private final Map<String, List<Product>> inventory = new ConcurrentHashMap<>();

// При добавлении
inventory.computeIfAbsent(category, k -> new CopyOnWriteArrayList<>()).add(product);

// При извлечении с удалением
public Product takeProduct(String category) throws OutOfStockException {
    List<Product> products = inventory.get(category);
    
    if (products == null || products.isEmpty()) {
        throw new OutOfStockException("No products in category: " + category);
    }
    
    // Для CopyOnWriteArrayList remove создаёт новую копию
    synchronized (products) {
        if (products.isEmpty()) {
            throw new OutOfStockException("No products in category: " + category);
        }
        return products.remove(0);
    }
}
```

### 2. Управление флагом `isInventoryOpen`
```java
private volatile boolean isInventoryOpen = true; // volatile для видимости между потоками

public void closeInventory() {
    this.isInventoryOpen = false;
    System.out.println("Склад закрыт");
}

public void openInventory() {
    this.isInventoryOpen = true;
    System.out.println("Склад открыт");
}
```

### 3. Обработка исключений
```java
public List<Product> getProductsByCategory(String category) throws OutOfStockException {
    if (!isInventoryOpen) {
        throw new IllegalStateException("Inventory is closed");
    }
    
    List<Product> products = inventory.get(category);
    
    if (products == null || products.isEmpty()) {
        throw new OutOfStockException("No products in category: " + category);
    }
    
    return new ArrayList<>(products);
}
```

### 4. Фильтрация с использованием Stream API
```java
public List<Product> filterProductsByPriceRange(String category, double min, double max) 
        throws OutOfStockException {
    
    return getProductsByCategory(category).stream()
            .filter(p -> p.getPrice() >= min && p.getPrice() <= max)
            .sorted(Comparator.comparingDouble(Product::getPrice))
            .collect(Collectors.toList());
}
```

---

## Тестирование

### Что нужно протестировать

1. **Добавление товаров**:
    - Добавление товара при открытом складе → товар добавлен.
    - Добавление товара при закрытом складе → товар не добавлен (возврат `false` или исключение).
    - Добавление `null` → исключение.
    - Добавление товара в новую категорию → категория создаётся.

2. **Извлечение товаров**:
    - Извлечение из существующей категории с товарами → успех.
    - Извлечение из несуществующей категории → `OutOfStockException`.
    - Извлечение из существующей категории без товаров → `OutOfStockException`.
    - Извлечение с удалением (метод `takeProduct`) → товар удалён из списка.

3. **Фильтрация по цене**:
    - Фильтрация существующей категории → корректный список.
    - Пустой результат фильтрации → пустой список (не исключение).
    - Граничные значения цены.

4. **Управление доступом**:
    - При закрытом складе добавление не работает.
    - При закрытом складе извлечение может работать или нет (по заданию).

5. **Потокобезопасность**:
    - Одновременное добавление товаров из нескольких потоков.
    - Одновременное добавление и извлечение.

### Пример тестов (JUnit)

```java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.concurrent.*;

public class InventoryServiceTest {
    private InventoryService inventoryService;
    private Product product1;
    private Product product2;
    private Product product3;
    
    @BeforeEach
    public void setUp() {
        inventoryService = new InventoryService(true);
        product1 = new Product("Ноутбук", 75000, "Электроника");
        product2 = new Product("Мышь", 1500, "Электроника");
        product3 = new Product("Стол", 12000, "Мебель");
    }
    
    @Test
    public void testAddProductWhenOpen() {
        boolean result = inventoryService.addProduct(product1);
        
        assertTrue(result);
        assertEquals(1, inventoryService.getProductCount("Электроника"));
    }
    
    @Test
    public void testAddProductWhenClosed() {
        inventoryService.setInventoryOpen(false);
        
        boolean result = inventoryService.addProduct(product1);
        
        assertFalse(result);
        assertEquals(0, inventoryService.getProductCount("Электроника"));
    }
    
    @Test
    public void testAddNullProductThrowsException() {
        assertThrows(IllegalArgumentException.class, 
            () -> inventoryService.addProduct(null));
    }
    
    @Test
    public void testGetProductsByCategory() throws OutOfStockException {
        inventoryService.addProduct(product1);
        inventoryService.addProduct(product2);
        
        List<Product> electronics = inventoryService.getProductsByCategory("Электроника");
        
        assertEquals(2, electronics.size());
        assertTrue(electronics.contains(product1));
        assertTrue(electronics.contains(product2));
    }
    
    @Test
    public void testGetProductsByNonExistentCategory() {
        assertThrows(OutOfStockException.class, 
            () -> inventoryService.getProductsByCategory("Несуществующая"));
    }
    
    @Test
    public void testTakeProduct() throws OutOfStockException {
        inventoryService.addProduct(product1);
        inventoryService.addProduct(product2);
        
        Product taken = inventoryService.takeProduct("Электроника");
        
        assertEquals(product1, taken); // Берём первый добавленный
        assertEquals(1, inventoryService.getProductCount("Электроника"));
    }
    
    @Test
    public void testFilterProductsByPrice() throws OutOfStockException {
        inventoryService.addProduct(product1); // 75000
        inventoryService.addProduct(product2); // 1500
        
        List<Product> cheap = inventoryService.filterProductsByPriceRange(
            "Электроника", 0, 5000);
        
        assertEquals(1, cheap.size());
        assertEquals(product2, cheap.get(0));
    }
    
    @Test
    public void testSearchProductByName() {
        inventoryService.addProduct(product1);
        inventoryService.addProduct(product2);
        inventoryService.addProduct(product3);
        
        List<Product> found = inventoryService.searchProductByName("ноут");
        
        assertEquals(1, found.size());
        assertEquals(product1, found.get(0));
    }
    
    @Test
    public void testConcurrentAddProducts() throws InterruptedException, ExecutionException {
        int threadCount = 10;
        int productsPerThread = 100;
        
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        CountDownLatch latch = new CountDownLatch(threadCount);
        
        for (int t = 0; t < threadCount; t++) {
            executor.submit(() -> {
                try {
                    for (int i = 0; i < productsPerThread; i++) {
                        Product product = new Product(
                            "Товар-" + i, 
                            100 + i, 
                            "Категория-" + (i % 3)
                        );
                        inventoryService.addProduct(product);
                    }
                } finally {
                    latch.countDown();
                }
            });
        }
        
        latch.await();
        executor.shutdown();
        
        assertEquals(threadCount * productsPerThread, 
                inventoryService.getTotalProductCount());
    }
    
    @Test
    public void testInventoryStateAfterClose() {
        inventoryService.addProduct(product1);
        assertEquals(1, inventoryService.getTotalProductCount());
        
        inventoryService.setInventoryOpen(false);
        
        boolean added = inventoryService.addProduct(product2);
        assertFalse(added);
        assertEquals(1, inventoryService.getTotalProductCount()); // Не изменилось
    }
}
```

---

## Пример использования

```java
public class Main {
    public static void main(String[] args) {
        // Создаём склад (открыт по умолчанию)
        InventoryService warehouse = new InventoryService();
        
        System.out.println("=== Добавление товаров ===");
        
        // Добавляем товары
        warehouse.addProduct(new Product("Ноутбук Dell", 85000, "Электроника"));
        warehouse.addProduct(new Product("Ноутбук HP", 65000, "Электроника"));
        warehouse.addProduct(new Product("Мышь Logitech", 2500, "Электроника"));
        warehouse.addProduct(new Product("Клавиатура", 3500, "Электроника"));
        warehouse.addProduct(new Product("Стол письменный", 15000, "Мебель"));
        warehouse.addProduct(new Product("Стул офисный", 8000, "Мебель"));
        
        System.out.println("\n=== Получение товаров по категориям ===");
        try {
            List<Product> electronics = warehouse.getProductsByCategory("Электроника");
            System.out.println("Электроника (" + electronics.size() + " шт.):");
            electronics.forEach(p -> System.out.println("  " + p));
            
            List<Product> furniture = warehouse.getProductsByCategory("Мебель");
            System.out.println("Мебель (" + furniture.size() + " шт.):");
            furniture.forEach(p -> System.out.println("  " + p));
            
        } catch (OutOfStockException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
        
        System.out.println("\n=== Фильтрация по цене (Электроника до 10000) ===");
        try {
            List<Product> cheapElectronics = warehouse.filterProductsByMaxPrice(
                "Электроника", 10000);
            cheapElectronics.forEach(p -> 
                System.out.println("  " + p.getName() + " - " + p.getPrice() + " руб."));
            
        } catch (OutOfStockException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
        
        System.out.println("\n=== Извлечение товара со склада (FIFO) ===");
        try {
            Product taken = warehouse.takeProduct("Электроника");
            System.out.println("Выдан товар: " + taken);
            System.out.println("Осталось электроники: " + 
                warehouse.getProductCount("Электроника") + " шт.");
            
        } catch (OutOfStockException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
        
        System.out.println("\n=== Закрытие склада ===");
        warehouse.setInventoryOpen(false);
        
        boolean added = warehouse.addProduct(new Product("Планшет", 30000, "Электроника"));
        System.out.println("Попытка добавить товар при закрытом складе: " + 
            (added ? "успешно" : "отклонено"));
        
        System.out.println("\n=== Поиск товара по названию ===");
        List<Product> found = warehouse.searchProductByName("стол");
        System.out.println("Найдено товаров со словом 'стол': " + found.size());
        found.forEach(p -> System.out.println("  " + p));
    }
}
```

Вывод:
```
=== Добавление товаров ===
Товар добавлен на склад: Product{name='Ноутбук Dell', price=85000.00, category='Электроника'}
Товар добавлен на склад: Product{name='Ноутбук HP', price=65000.00, category='Электроника'}
Товар добавлен на склад: Product{name='Мышь Logitech', price=2500.00, category='Электроника'}
Товар добавлен на склад: Product{name='Клавиатура', price=3500.00, category='Электроника'}
Товар добавлен на склад: Product{name='Стол письменный', price=15000.00, category='Мебель'}
Товар добавлен на склад: Product{name='Стул офисный', price=8000.00, category='Мебель'}

=== Получение товаров по категориям ===
Электроника (4 шт.):
  Product{name='Ноутбук Dell', price=85000.00, category='Электроника'}
  Product{name='Ноутбук HP', price=65000.00, category='Электроника'}
  Product{name='Мышь Logitech', price=2500.00, category='Электроника'}
  Product{name='Клавиатура', price=3500.00, category='Электроника'}
Мебель (2 шт.):
  Product{name='Стол письменный', price=15000.00, category='Мебель'}
  Product{name='Стул офисный', price=8000.00, category='Мебель'}

=== Фильтрация по цене (Электроника до 10000) ===
  Мышь Logitech - 2500.0 руб.
  Клавиатура - 3500.0 руб.

=== Извлечение товара со склада (FIFO) ===
Выдан товар: Product{name='Ноутбук Dell', price=85000.00, category='Электроника'}
Осталось электроники: 3 шт.

=== Закрытие склада ===
Попытка добавить товар при закрытом складе: отклонено

=== Поиск товара по названию ===
Найдено товаров со словом 'стол': 1
  Product{name='Стол письменный', price=15000.00, category='Мебель'}
```

---
