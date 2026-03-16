---

# Задача 6: Сервис задач (Task Manager)

## Описание
Разработайте сервис для управления задачами, который позволяет добавлять, удалять и искать задачи по различным критериям. Каждая задача будет иметь уникальный идентификатор обобщённого типа, статус, приоритет и дату.

## Ключевые темы
- **Дженерики**: Уникальный идентификатор обобщённого типа `T`
- **Коллекции**: Хранение задач в потокобезопасной коллекции
- **Stream API**: Фильтрация по статусу и приоритету, сортировка по дате
- **Лямбда-выражения**: Для компараторов и предикатов
- **Потокобезопасность**: Синхронизация операций удаления
- **Тестирование**: Всех сценариев использования

---

## Классы и интерфейсы

### Класс `Task<T>`
Класс, представляющий задачу с уникальным идентификатором, статусом, приоритетом и датой.

```java
import java.time.LocalDateTime;
import java.util.Objects;

public class Task<T> {
    private final T id;
    private String title;
    private String description;
    private TaskStatus status;
    private TaskPriority priority;
    private LocalDateTime createdAt;
    private LocalDateTime dueDate;
    
    public enum TaskStatus {
        TODO, IN_PROGRESS, DONE, CANCELLED
    }
    
    public enum TaskPriority {
        LOW, MEDIUM, HIGH, CRITICAL
    }
    
    // Конструктор с обязательными полями
    public Task(T id, String title, TaskPriority priority) {
        this(id, title, priority, LocalDateTime.now());
    }
    
    public Task(T id, String title, TaskPriority priority, LocalDateTime dueDate) {
        this.id = id;
        this.title = title;
        this.priority = priority;
        this.status = TaskStatus.TODO;
        this.createdAt = LocalDateTime.now();
        this.dueDate = dueDate;
        this.description = "";
    }
    
    // Полный конструктор
    public Task(T id, String title, String description, TaskStatus status, 
                TaskPriority priority, LocalDateTime createdAt, LocalDateTime dueDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.createdAt = createdAt;
        this.dueDate = dueDate;
    }
    
    // Геттеры
    public T getId() {
        return id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getDescription() {
        return description;
    }
    
    public TaskStatus getStatus() {
        return status;
    }
    
    public TaskPriority getPriority() {
        return priority;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public LocalDateTime getDueDate() {
        return dueDate;
    }
    
    // Сеттеры (для изменяемых полей)
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setStatus(TaskStatus status) {
        this.status = status;
    }
    
    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }
    
    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task<?> task = (Task<?>) o;
        return Objects.equals(id, task.id);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
    @Override
    public String toString() {
        return String.format("Task{id=%s, title='%s', status=%s, priority=%s, dueDate=%s}",
                id, title, status, priority, 
                dueDate != null ? dueDate.toLocalDate() : "null");
    }
}
```

### Класс `TaskService<T>`
Сервис для управления задачами.

```java
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class TaskService<T> {
    private final Map<T, Task<T>> tasks;
    private final List<Task<T>> taskList; // Для потокобезопасной итерации
    
    public TaskService() {
        this.tasks = new ConcurrentHashMap<>();
        this.taskList = new CopyOnWriteArrayList<>();
    }
    
    // Основные методы будут реализованы ниже
}
```

---

## Функциональные требования

### 1. Добавление задачи
- Метод для добавления новой задачи.
- ID задачи должен быть **уникальным**.
- Если задача с таким ID уже существует, добавление не производится (можно возвращать `false` или выбрасывать исключение).

```java
public boolean addTask(Task<T> task) {
    Objects.requireNonNull(task, "Task cannot be null");
    Objects.requireNonNull(task.getId(), "Task ID cannot be null");
    
    Task<T> existing = tasks.putIfAbsent(task.getId(), task);
    if (existing == null) {
        taskList.add(task);
        return true;
    }
    return false; // Задача с таким ID уже существует
}

// Вариант с исключением
public void addTaskOrThrow(Task<T> task) throws DuplicateTaskException {
    Objects.requireNonNull(task, "Task cannot be null");
    
    if (tasks.containsKey(task.getId())) {
        throw new DuplicateTaskException("Task with ID " + task.getId() + " already exists");
    }
    
    tasks.put(task.getId(), task);
    taskList.add(task);
}
```

### 2. Удаление задачи
- Метод для удаления задачи по ID.
- Должен быть **синхронизирован** для предотвращения конкурентного доступа.
- Возвращает `true`, если задача была удалена, и `false`, если задача не найдена.

```java
public synchronized boolean removeTask(T id) {
    Objects.requireNonNull(id, "Task ID cannot be null");
    
    Task<T> removed = tasks.remove(id);
    if (removed != null) {
        taskList.remove(removed);
        return true;
    }
    return false;
}
```

### 3. Получение задачи по ID
```java
public Optional<Task<T>> getTask(T id) {
    Objects.requireNonNull(id, "Task ID cannot be null");
    return Optional.ofNullable(tasks.get(id));
}
```

### 4. Поиск задач по статусу
- Использование **Stream API** для фильтрации.
- Возвращает список задач с указанным статусом.

```java
public List<Task<T>> findTasksByStatus(Task.TaskStatus status) {
    Objects.requireNonNull(status, "Status cannot be null");
    
    return taskList.stream()
            .filter(task -> task.getStatus() == status)
            .collect(Collectors.toList());
}
```

### 5. Поиск задач по приоритету
```java
public List<Task<T>> findTasksByPriority(Task.TaskPriority priority) {
    Objects.requireNonNull(priority, "Priority cannot be null");
    
    return taskList.stream()
            .filter(task -> task.getPriority() == priority)
            .collect(Collectors.toList());
}
```

### 6. Поиск задач по статусу и приоритету (комбинированный)
```java
public List<Task<T>> findTasksByStatusAndPriority(Task.TaskStatus status, Task.TaskPriority priority) {
    Objects.requireNonNull(status, "Status cannot be null");
    Objects.requireNonNull(priority, "Priority cannot be null");
    
    return taskList.stream()
            .filter(task -> task.getStatus() == status && task.getPriority() == priority)
            .collect(Collectors.toList());
}
```

### 7. Сортировка задач по дате
- Использование **Stream API** и **лямбда-выражений**.
- Возможность сортировки по возрастанию или убыванию.

```java
// Сортировка по дате создания (по умолчанию)
public List<Task<T>> getTasksSortedByCreationDate(boolean ascending) {
    Comparator<Task<T>> comparator = Comparator.comparing(Task::getCreatedAt);
    
    if (!ascending) {
        comparator = comparator.reversed();
    }
    
    return taskList.stream()
            .sorted(comparator)
            .collect(Collectors.toList());
}

// Сортировка по сроку выполнения (due date)
public List<Task<T>> getTasksSortedByDueDate(boolean ascending) {
    Comparator<Task<T>> comparator = Comparator.comparing(
        Task::getDueDate,
        Comparator.nullsLast(Comparator.naturalOrder())
    );
    
    if (!ascending) {
        comparator = comparator.reversed();
    }
    
    return taskList.stream()
            .sorted(comparator)
            .collect(Collectors.toList());
}

// Сортировка по приоритету (CRITICAL > HIGH > MEDIUM > LOW)
public List<Task<T>> getTasksSortedByPriority() {
    return taskList.stream()
            .sorted((t1, t2) -> {
                // Порядок приоритетов: CRITICAL (3), HIGH (2), MEDIUM (1), LOW (0)
                int p1 = t1.getPriority().ordinal();
                int p2 = t2.getPriority().ordinal();
                return Integer.compare(p2, p1); // По убыванию (высший приоритет первый)
            })
            .collect(Collectors.toList());
}
```

### 8. Поиск задач с фильтрацией и сортировкой (комбинированный)
```java
public List<Task<T>> findTasks(Task.TaskStatus status, Task.TaskPriority priority, 
                               boolean sortByDueDate) {
    return taskList.stream()
            .filter(task -> status == null || task.getStatus() == status)
            .filter(task -> priority == null || task.getPriority() == priority)
            .sorted(sortByDueDate 
                ? Comparator.comparing(Task::getDueDate, Comparator.nullsLast(Comparator.naturalOrder()))
                : Comparator.comparing(Task::getCreatedAt).reversed())
            .collect(Collectors.toList());
}
```

### 9. Дополнительные полезные методы

```java
// Получить все задачи
public List<Task<T>> getAllTasks() {
    return new ArrayList<>(taskList);
}

// Получить количество задач
public int getTaskCount() {
    return tasks.size();
}

// Получить задачи, просроченные на текущий момент
public List<Task<T>> getOverdueTasks() {
    LocalDateTime now = LocalDateTime.now();
    
    return taskList.stream()
            .filter(task -> task.getDueDate() != null && task.getDueDate().isBefore(now))
            .filter(task -> task.getStatus() != Task.TaskStatus.DONE)
            .collect(Collectors.toList());
}

// Обновить статус задачи
public synchronized boolean updateTaskStatus(T id, Task.TaskStatus newStatus) {
    return getTask(id)
            .map(task -> {
                task.setStatus(newStatus);
                return true;
            })
            .orElse(false);
}

// Поиск задач по части названия
public List<Task<T>> searchTasksByTitle(String keyword) {
    Objects.requireNonNull(keyword, "Keyword cannot be null");
    String lowerKeyword = keyword.toLowerCase();
    
    return taskList.stream()
            .filter(task -> task.getTitle().toLowerCase().contains(lowerKeyword))
            .collect(Collectors.toList());
}
```

---

## Рекомендации по реализации

### 1. Уникальность ID
Для обеспечения уникальности ID используйте:
- `ConcurrentHashMap` как основное хранилище (проверка по ключу)
- Проверку при добавлении через `putIfAbsent`

### 2. Потокобезопасность
- Для операций удаления используйте `synchronized`
- Для хранения задач можно использовать `ConcurrentHashMap` и `CopyOnWriteArrayList`
- Для итераций без блокировок подходит `CopyOnWriteArrayList`

```java
public synchronized boolean removeTask(T id) {
    Task<T> removed = tasks.remove(id);
    if (removed != null) {
        taskList.remove(removed);
        return true;
    }
    return false;
}
```

### 3. Исключения для дубликатов
```java
public class DuplicateTaskException extends Exception {
    public DuplicateTaskException(String message) {
        super(message);
    }
}
```

### 4. Фильтрация с Optional
```java
public Optional<Task<T>> findTaskById(T id) {
    return Optional.ofNullable(tasks.get(id));
}
```

### 5. Сортировка с null-значениями
```java
Comparator.comparing(
    Task::getDueDate,
    Comparator.nullsLast(Comparator.naturalOrder())
)
```

---

## Тестирование

### Что нужно протестировать

1. **Добавление задач**:
    - Добавление новой задачи с уникальным ID → успех.
    - Добавление задачи с существующим ID → отклонение (false или исключение).
    - Добавление задачи с `null` ID → исключение.

2. **Удаление задач**:
    - Удаление существующей задачи → true, задача удалена.
    - Удаление несуществующей задачи → false.
    - Удаление с `null` ID → исключение.

3. **Поиск по статусу и приоритету**:
    - Фильтрация по одному критерию → корректный список.
    - Фильтрация по комбинации критериев → корректный список.
    - Пустой результат → пустой список.

4. **Сортировка**:
    - По дате создания (возрастание/убывание).
    - По сроку выполнения (с учётом `null`).
    - По приоритету.

5. **Потокобезопасность**:
    - Одновременное добавление задач из нескольких потоков.
    - Одновременное удаление и добавление.
    - Одновременное чтение и модификация.

### Пример тестов (JUnit)

```java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.*;

public class TaskServiceTest {
    private TaskService<String> taskService;
    private Task<String> task1;
    private Task<String> task2;
    private Task<String> task3;
    
    @BeforeEach
    public void setUp() {
        taskService = new TaskService<>();
        
        LocalDateTime now = LocalDateTime.now();
        
        task1 = new Task<>("1", "Задача 1", Task.TaskPriority.HIGH);
        task1.setDueDate(now.plusDays(1));
        
        task2 = new Task<>("2", "Задача 2", Task.TaskPriority.MEDIUM);
        task2.setDueDate(now.plusDays(3));
        task2.setStatus(Task.TaskStatus.IN_PROGRESS);
        
        task3 = new Task<>("3", "Задача 3", Task.TaskPriority.LOW);
        task3.setDueDate(now.plusDays(5));
    }
    
    @Test
    public void testAddTask() {
        assertTrue(taskService.addTask(task1));
        assertEquals(1, taskService.getTaskCount());
        assertEquals(task1, taskService.getTask("1").orElse(null));
    }
    
    @Test
    public void testAddDuplicateTask() {
        taskService.addTask(task1);
        assertFalse(taskService.addTask(task1)); // Дубликат
        assertEquals(1, taskService.getTaskCount());
    }
    
    @Test
    public void testAddNullTaskThrowsException() {
        assertThrows(NullPointerException.class, () -> taskService.addTask(null));
    }
    
    @Test
    public void testRemoveTask() {
        taskService.addTask(task1);
        
        assertTrue(taskService.removeTask("1"));
        assertFalse(taskService.getTask("1").isPresent());
        assertEquals(0, taskService.getTaskCount());
    }
    
    @Test
    public void testRemoveNonExistentTask() {
        assertFalse(taskService.removeTask("999"));
    }
    
    @Test
    public void testFindTasksByStatus() {
        taskService.addTask(task1); // TODO
        taskService.addTask(task2); // IN_PROGRESS
        taskService.addTask(task3); // TODO
        
        List<Task<String>> todoTasks = taskService.findTasksByStatus(Task.TaskStatus.TODO);
        
        assertEquals(2, todoTasks.size());
        assertTrue(todoTasks.contains(task1));
        assertTrue(todoTasks.contains(task3));
    }
    
    @Test
    public void testFindTasksByPriority() {
        taskService.addTask(task1); // HIGH
        taskService.addTask(task2); // MEDIUM
        taskService.addTask(task3); // LOW
        
        List<Task<String>> highTasks = taskService.findTasksByPriority(Task.TaskPriority.HIGH);
        
        assertEquals(1, highTasks.size());
        assertEquals(task1, highTasks.get(0));
    }
    
    @Test
    public void testFindTasksByStatusAndPriority() {
        taskService.addTask(task1); // TODO, HIGH
        taskService.addTask(task2); // IN_PROGRESS, MEDIUM
        taskService.addTask(new Task<>("4", "Задача 4", Task.TaskPriority.HIGH)); // TODO, HIGH
        
        List<Task<String>> todoHighTasks = taskService.findTasksByStatusAndPriority(
            Task.TaskStatus.TODO, Task.TaskPriority.HIGH);
        
        assertEquals(2, todoHighTasks.size());
    }
    
    @Test
    public void testSortByCreationDate() {
        // Задачи уже добавлены с разным временем создания
        taskService.addTask(task1);
        taskService.addTask(task2);
        taskService.addTask(task3);
        
        List<Task<String>> ascending = taskService.getTasksSortedByCreationDate(true);
        List<Task<String>> descending = taskService.getTasksSortedByCreationDate(false);
        
        assertEquals(task1, ascending.get(0)); // Самая старая
        assertEquals(task3, descending.get(0)); // Самая новая
    }
    
    @Test
    public void testSortByDueDate() {
        taskService.addTask(task1); // due +1
        taskService.addTask(task2); // due +3
        taskService.addTask(task3); // due +5
        
        List<Task<String>> sorted = taskService.getTasksSortedByDueDate(true);
        
        assertEquals(task1, sorted.get(0)); // Самый близкий срок
        assertEquals(task3, sorted.get(2)); // Самый дальний срок
    }
    
    @Test
    public void testSortByPriority() {
        taskService.addTask(task3); // LOW
        taskService.addTask(task2); // MEDIUM
        taskService.addTask(task1); // HIGH
        
        List<Task<String>> sorted = taskService.getTasksSortedByPriority();
        
        assertEquals(task1, sorted.get(0)); // HIGH первый
        assertEquals(task2, sorted.get(1)); // MEDIUM второй
        assertEquals(task3, sorted.get(2)); // LOW третий
    }
    
    @Test
    public void testSearchByTitle() {
        taskService.addTask(task1);
        taskService.addTask(task2);
        taskService.addTask(task3);
        
        List<Task<String>> found = taskService.searchTasksByTitle("Задача");
        assertEquals(3, found.size());
        
        found = taskService.searchTasksByTitle("1");
        assertEquals(1, found.size());
        assertEquals(task1, found.get(0));
    }
    
    @Test
    public void testUpdateTaskStatus() {
        taskService.addTask(task1);
        
        assertTrue(taskService.updateTaskStatus("1", Task.TaskStatus.IN_PROGRESS));
        assertEquals(Task.TaskStatus.IN_PROGRESS, taskService.getTask("1").get().getStatus());
        
        assertFalse(taskService.updateTaskStatus("999", Task.TaskStatus.DONE));
    }
    
    @Test
    public void testConcurrentAddAndRemove() throws InterruptedException, ExecutionException {
        int threadCount = 10;
        int tasksPerThread = 100;
        
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        CountDownLatch latch = new CountDownLatch(threadCount);
        
        for (int t = 0; t < threadCount; t++) {
            final int threadNum = t;
            executor.submit(() -> {
                try {
                    for (int i = 0; i < tasksPerThread; i++) {
                        String id = threadNum + "-" + i;
                        Task<String> task = new Task<>(id, "Task " + id, Task.TaskPriority.MEDIUM);
                        taskService.addTask(task);
                    }
                } finally {
                    latch.countDown();
                }
            });
        }
        
        latch.await();
        executor.shutdown();
        
        assertEquals(threadCount * tasksPerThread, taskService.getTaskCount());
        
        // Параллельное удаление
        executor = Executors.newFixedThreadPool(threadCount);
        latch = new CountDownLatch(threadCount);
        
        for (int t = 0; t < threadCount; t++) {
            final int threadNum = t;
            executor.submit(() -> {
                try {
                    for (int i = 0; i < tasksPerThread; i++) {
                        String id = threadNum + "-" + i;
                        taskService.removeTask(id);
                    }
                } finally {
                    latch.countDown();
                }
            });
        }
        
        latch.await();
        executor.shutdown();
        
        assertEquals(0, taskService.getTaskCount());
    }
}
```

---

## Пример использования

```java
public class Main {
    public static void main(String[] args) {
        // Создаём сервис задач с строковыми идентификаторами
        TaskService<String> taskManager = new TaskService<>();
        
        System.out.println("=== Добавление задач ===");
        
        // Создаём задачи
        LocalDateTime now = LocalDateTime.now();
        
        Task<String> task1 = new Task<>("1", "Разработать архитектуру", Task.TaskPriority.HIGH);
        task1.setDueDate(now.plusDays(2));
        
        Task<String> task2 = new Task<>("2", "Написать код", Task.TaskPriority.HIGH);
        task2.setDueDate(now.plusDays(5));
        task2.setStatus(Task.TaskStatus.IN_PROGRESS);
        
        Task<String> task3 = new Task<>("3", "Написать тесты", Task.TaskPriority.MEDIUM);
        task3.setDueDate(now.plusDays(7));
        
        Task<String> task4 = new Task<>("4", "Документировать код", Task.TaskPriority.LOW);
        task4.setDueDate(now.plusDays(10));
        
        // Добавляем задачи
        taskManager.addTask(task1);
        taskManager.addTask(task2);
        taskManager.addTask(task3);
        taskManager.addTask(task4);
        
        System.out.println("Всего задач: " + taskManager.getTaskCount());
        
        System.out.println("\n=== Поиск задач по статусу ===");
        List<Task<String>> todoTasks = taskManager.findTasksByStatus(Task.TaskStatus.TODO);
        System.out.println("Задачи в статусе TODO:");
        todoTasks.forEach(t -> System.out.println("  " + t));
        
        System.out.println("\n=== Поиск задач по приоритету ===");
        List<Task<String>> highTasks = taskManager.findTasksByPriority(Task.TaskPriority.HIGH);
        System.out.println("Задачи с высоким приоритетом:");
        highTasks.forEach(t -> System.out.println("  " + t));
        
        System.out.println("\n=== Сортировка по сроку выполнения ===");
        List<Task<String>> sortedByDueDate = taskManager.getTasksSortedByDueDate(true);
        System.out.println("Задачи, отсортированные по сроку (ближайшие первые):");
        sortedByDueDate.forEach(t -> System.out.println("  " + t));
        
        System.out.println("\n=== Просроченные задачи ===");
        // Создадим просроченную задачу
        Task<String> overdueTask = new Task<>("5", "Просроченная задача", Task.TaskPriority.MEDIUM);
        overdueTask.setDueDate(now.minusDays(1));
        taskManager.addTask(overdueTask);
        
        List<Task<String>> overdue = taskManager.getOverdueTasks();
        System.out.println("Просроченных задач: " + overdue.size());
        overdue.forEach(t -> System.out.println("  " + t));
        
        System.out.println("\n=== Поиск по названию ===");
        List<Task<String>> found = taskManager.searchTasksByTitle("код");
        System.out.println("Найдено задач со словом 'код':");
        found.forEach(t -> System.out.println("  " + t));
        
        System.out.println("\n=== Удаление задачи ===");
        boolean removed = taskManager.removeTask("1");
        System.out.println("Задача с ID=1 удалена: " + removed);
        System.out.println("Осталось задач: " + taskManager.getTaskCount());
        
        System.out.println("\n=== Обновление статуса ===");
        taskManager.updateTaskStatus("2", Task.TaskStatus.DONE);
        System.out.println("Задача 2 после обновления: " + taskManager.getTask("2").orElse(null));
    }
}
```

Вывод:
```
=== Добавление задач ===
Всего задач: 4

=== Поиск задач по статусу ===
Задачи в статусе TODO:
  Task{id=1, title='Разработать архитектуру', status=TODO, priority=HIGH, dueDate=...}
  Task{id=3, title='Написать тесты', status=TODO, priority=MEDIUM, dueDate=...}
  Task{id=4, title='Документировать код', status=TODO, priority=LOW, dueDate=...}

=== Поиск задач по приоритету ===
Задачи с высоким приоритетом:
  Task{id=1, title='Разработать архитектуру', status=TODO, priority=HIGH, dueDate=...}
  Task{id=2, title='Написать код', status=IN_PROGRESS, priority=HIGH, dueDate=...}

=== Сортировка по сроку выполнения ===
Задачи, отсортированные по сроку (ближайшие первые):
  Task{id=1, title='Разработать архитектуру', status=TODO, priority=HIGH, dueDate=...}
  Task{id=2, title='Написать код', status=IN_PROGRESS, priority=HIGH, dueDate=...}
  Task{id=3, title='Написать тесты', status=TODO, priority=MEDIUM, dueDate=...}
  Task{id=4, title='Документировать код', status=TODO, priority=LOW, dueDate=...}

=== Просроченные задачи ===
Просроченных задач: 1
  Task{id=5, title='Просроченная задача', status=TODO, priority=MEDIUM, dueDate=...}

=== Поиск по названию ===
Найдено задач со словом 'код':
  Task{id=2, title='Написать код', status=IN_PROGRESS, priority=HIGH, dueDate=...}
  Task{id=4, title='Документировать код', status=TODO, priority=LOW, dueDate=...}

=== Удаление задачи ===
Задача с ID=1 удалена: true
Осталось задач: 4

=== Обновление статуса ===
Задача 2 после обновления: Task{id=2, title='Написать код', status=DONE, priority=HIGH, dueDate=...}
```

---
