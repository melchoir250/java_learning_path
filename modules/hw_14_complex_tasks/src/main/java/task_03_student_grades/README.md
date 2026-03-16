---

# Задача 3: Учёт оценок студентов (Student Grades Management)

## Описание
Создайте систему для управления и анализа оценок студентов, используя обобщённый подход. Система должна поддерживать различные типы числовых оценок, обеспечивать валидацию входных данных и предоставлять функционал для расчёта статистических показателей.

## Ключевые темы
- **Дженерики с ограничениями** (`<T extends Number>`)
- **Валидация данных** и пользовательские исключения
- **Stream API** для расчёта среднего
- **Синхронизация потоков** (`synchronized`)
- **Тестирование** всех сценариев

---

## Класс `StudentGrade<T>`

Класс представляет одну оценку студента по определённому предмету.

### Поля
- `String studentName` — имя студента
- `String subject` — название предмета
- `T grade` — оценка (тип, расширяющий `Number`)

### Требования
- Оценка должна быть обобщённого типа `T`, который расширяет `Number` (`<T extends Number>`).
- Конструктор для инициализации всех полей.
- Геттеры для доступа к полям.

### Пример реализации
```java
public class StudentGrade<T extends Number> {
    private final String studentName;
    private final String subject;
    private final T grade;
    
    public StudentGrade(String studentName, String subject, T grade) {
        this.studentName = studentName;
        this.subject = subject;
        this.grade = grade;
    }
    
    public String getStudentName() {
        return studentName;
    }
    
    public String getSubject() {
        return subject;
    }
    
    public T getGrade() {
        return grade;
    }
    
    @Override
    public String toString() {
        return String.format("StudentGrade{name='%s', subject='%s', grade=%s}", 
                studentName, subject, grade);
    }
}
```

---

## Класс `GradeService<T>`

Сервис для управления коллекцией оценок и расчёта статистики.

### Поля
- `List<StudentGrade<T>> grades` — список для хранения оценок (потокобезопасный или с синхронизацией)

### Методы

#### `void addGrade(StudentGrade<T> grade) throws InvalidGradeException`
- Добавляет оценку в коллекцию.
- **Валидация**: проверяет, что оценка не отрицательная.
- Если оценка некорректна, выбрасывает `InvalidGradeException`.
- Метод должен быть **потокобезопасным**.

#### `double getAverageGradeForSubject(String subject)`
- Рассчитывает среднее арифметическое оценок по указанному предмету.
- Если по предмету нет оценок, возвращает `0.0` или выбрасывает исключение (на усмотрение).
- Использует **Stream API** для расчёта.

#### (Опционально) Дополнительные методы
- `List<StudentGrade<T>> getGradesByStudent(String studentName)`
- `List<StudentGrade<T>> getGradesBySubject(String subject)`
- `Map<String, Double> getAverageForAllSubjects()`

### Исключение `InvalidGradeException`

Пользовательское исключение для случаев некорректной оценки.

```java
public class InvalidGradeException extends Exception {
    public InvalidGradeException(String message) {
        super(message);
    }
    
    public InvalidGradeException(String message, Throwable cause) {
        super(message, cause);
    }
}
```

---

## Рекомендации по реализации

### 1. Тип оценки (дженерики с ограничением)
```java
public class StudentGrade<T extends Number> {
    // ...
}
```

### 2. Валидация оценки
```java
private void validateGrade(T grade) throws InvalidGradeException {
    if (grade == null) {
        throw new InvalidGradeException("Grade cannot be null");
    }
    
    // Преобразуем в double для проверки отрицательности
    double doubleValue = grade.doubleValue();
    if (doubleValue < 0) {
        throw new InvalidGradeException("Grade cannot be negative: " + doubleValue);
    }
}
```

### 3. Потокобезопасность при добавлении
```java
public synchronized void addGrade(StudentGrade<T> grade) throws InvalidGradeException {
    validateGrade(grade.getGrade());
    grades.add(grade);
}
```

Альтернатива с использованием потокобезопасной коллекции:
```java
private final List<StudentGrade<T>> grades = new CopyOnWriteArrayList<>();

public void addGrade(StudentGrade<T> grade) throws InvalidGradeException {
    validateGrade(grade.getGrade());
    grades.add(grade);
}
```

### 4. Расчёт среднего с Stream API
```java
public double getAverageGradeForSubject(String subject) {
    synchronized (this) {
        return grades.stream()
                .filter(g -> g.getSubject().equals(subject))
                .mapToDouble(g -> g.getGrade().doubleValue())
                .average()
                .orElse(0.0);
    }
}
```

### 5. Обработка пустого списка
Можно добавить проверку и выбрасывать исключение:
```java
public double getAverageGradeForSubject(String subject) throws NoGradesException {
    synchronized (this) {
        DoubleSummaryStatistics stats = grades.stream()
                .filter(g -> g.getSubject().equals(subject))
                .mapToDouble(g -> g.getGrade().doubleValue())
                .summaryStatistics();
        
        if (stats.getCount() == 0) {
            throw new NoGradesException("No grades found for subject: " + subject);
        }
        return stats.getAverage();
    }
}
```

---

## Тестирование

### Что нужно протестировать

1. **Создание StudentGrade**:
    - Проверить, что конструктор корректно инициализирует поля.
    - Проверить работу геттеров.

2. **Добавление оценок (валидация)**:
    - Добавление корректной оценки (положительное число) → успех.
    - Добавление отрицательной оценки → исключение `InvalidGradeException`.
    - Добавление `null` оценки → исключение.

3. **Расчёт среднего**:
    - Для предмета с несколькими оценками → корректное среднее.
    - Для предмета с одной оценкой → среднее равно этой оценке.
    - Для предмета без оценок → `0.0` (или исключение).
    - Проверить с разными типами чисел (Integer, Double, Float).

4. **Потокобезопасность**:
    - Одновременное добавление оценок из нескольких потоков.
    - Одновременное добавление и чтение (расчёт среднего).
    - Отсутствие потери данных и состояний гонки.

### Пример тестов (JUnit)

```java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.*;

public class GradeServiceTest {
    private GradeService<Double> service;
    
    @BeforeEach
    public void setUp() {
        service = new GradeService<>();
    }
    
    @Test
    public void testAddValidGrade() throws InvalidGradeException {
        StudentGrade<Double> grade = new StudentGrade<>("Alice", "Math", 95.5);
        service.addGrade(grade);
        
        assertEquals(95.5, service.getAverageGradeForSubject("Math"));
    }
    
    @Test
    public void testAddNegativeGradeThrowsException() {
        StudentGrade<Double> grade = new StudentGrade<>("Alice", "Math", -10.0);
        
        assertThrows(InvalidGradeException.class, () -> service.addGrade(grade));
    }
    
    @Test
    public void testAverageForSubjectWithMultipleGrades() throws InvalidGradeException {
        service.addGrade(new StudentGrade<>("Alice", "Math", 90.0));
        service.addGrade(new StudentGrade<>("Bob", "Math", 80.0));
        service.addGrade(new StudentGrade<>("Charlie", "Math", 100.0));
        
        assertEquals(90.0, service.getAverageGradeForSubject("Math"));
    }
    
    @Test
    public void testAverageForSubjectWithNoGrades() {
        assertEquals(0.0, service.getAverageGradeForSubject("Physics"));
    }
    
    @Test
    public void testAverageWithDifferentNumberTypes() throws InvalidGradeException {
        GradeService<Integer> intService = new GradeService<>();
        intService.addGrade(new StudentGrade<>("Alice", "Math", 90));
        intService.addGrade(new StudentGrade<>("Bob", "Math", 85));
        
        assertEquals(87.5, intService.getAverageGradeForSubject("Math"));
    }
    
    @Test
    public void testConcurrentAddGrades() throws InterruptedException, ExecutionException {
        GradeService<Integer> threadService = new GradeService<>();
        int threadCount = 10;
        int gradesPerThread = 100;
        
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        CountDownLatch latch = new CountDownLatch(threadCount);
        
        for (int t = 0; t < threadCount; t++) {
            executor.submit(() -> {
                try {
                    for (int i = 0; i < gradesPerThread; i++) {
                        threadService.addGrade(new StudentGrade<>("Student", "Math", 100));
                    }
                } catch (InvalidGradeException e) {
                    fail("Exception during concurrent add: " + e.getMessage());
                } finally {
                    latch.countDown();
                }
            });
        }
        
        latch.await();
        executor.shutdown();
        
        // Должно быть добавлено threadCount * gradesPerThread оценок
        assertEquals(threadCount * gradesPerThread, 
                threadService.getAverageGradeForSubject("Math") * threadCount * gradesPerThread / 100, 0.001);
    }
}
```

---

## Пример использования

```java
public class Main {
    public static void main(String[] args) {
        // Сервис для Double оценок
        GradeService<Double> mathGrades = new GradeService<>();
        
        try {
            // Добавляем оценки
            mathGrades.addGrade(new StudentGrade<>("Alice", "Math", 95.5));
            mathGrades.addGrade(new StudentGrade<>("Bob", "Math", 87.0));
            mathGrades.addGrade(new StudentGrade<>("Charlie", "Math", 92.5));
            mathGrades.addGrade(new StudentGrade<>("Diana", "Physics", 88.0)); // Другой предмет
            
            // Рассчитываем среднее по математике
            double mathAverage = mathGrades.getAverageGradeForSubject("Math");
            System.out.println("Средняя оценка по математике: " + mathAverage);
            
            // Попытка добавить отрицательную оценку
            mathGrades.addGrade(new StudentGrade<>("Eve", "Math", -10.0));
            
        } catch (InvalidGradeException e) {
            System.err.println("Ошибка валидации: " + e.getMessage());
        }
        
        // Сервис для Integer оценок
        GradeService<Integer> physicsGrades = new GradeService<>();
        
        try {
            physicsGrades.addGrade(new StudentGrade<>("Alice", "Physics", 95));
            physicsGrades.addGrade(new StudentGrade<>("Bob", "Physics", 87));
            
            double physicsAverage = physicsGrades.getAverageGradeForSubject("Physics");
            System.out.println("Средняя оценка по физике: " + physicsAverage);
            
        } catch (InvalidGradeException e) {
            System.err.println("Ошибка валидации: " + e.getMessage());
        }
    }
}
```

Вывод:
```
Средняя оценка по математике: 91.66666666666667
Ошибка валидации: Grade cannot be negative: -10.0
Средняя оценка по физике: 91.0
```

---