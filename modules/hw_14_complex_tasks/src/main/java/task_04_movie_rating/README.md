---

# Задача 4: Рейтинг фильмов (Movie Rating System)

## Описание
Разработайте систему, которая позволяет пользователям ставить оценки фильмам и управлять этими оценками. Система должна поддерживать использование различных типов рейтингов, таких как целые числа или дробные значения, и предоставлять функциональность для расчёта средней оценки фильма, а также для сортировки фильмов по популярности.

## Ключевые темы
- **Дженерики с ограничениями** (`<T extends Number>`)
- **Коллекции**: `Map<Movie, List<Rating<?>>>`
- **Stream API** для расчёта среднего и сортировки
- **Лямбда-выражения** для компараторов
- **Потокобезопасность** при добавлении оценок
- **Валидация данных** и обработка исключений
- **Тестирование** всех сценариев

---

## Классы и интерфейсы

### Класс `Movie`
Класс, представляющий фильм с базовыми характеристиками.

```java
public class Movie {
    private final String title;
    private final int year;
    private final String director;
    // Другие поля по желанию (жанр, длительность и т.д.)
    
    public Movie(String title, int year, String director) {
        this.title = title;
        this.year = year;
        this.director = director;
    }
    
    // Геттеры
    public String getTitle() { return title; }
    public int getYear() { return year; }
    public String getDirector() { return director; }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return year == movie.year &&
               Objects.equals(title, movie.title) &&
               Objects.equals(director, movie.director);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(title, year, director);
    }
    
    @Override
    public String toString() {
        return String.format("Movie{title='%s', year=%d, director='%s'}", 
                title, year, director);
    }
}
```

### Класс `Rating<T extends Number>`
Класс для хранения рейтинга фильма с обобщённым числовым типом.

```java
public class Rating<T extends Number> {
    private final T value;
    private final String userId; // опционально: кто поставил оценку
    
    public Rating(T value) {
        this(value, null);
    }
    
    public Rating(T value, String userId) {
        this.value = value;
        this.userId = userId;
    }
    
    public T getValue() {
        return value;
    }
    
    public String getUserId() {
        return userId;
    }
    
    public double doubleValue() {
        return value.doubleValue();
    }
    
    @Override
    public String toString() {
        return String.format("Rating{value=%s, userId='%s'}", value, userId);
    }
}
```

### Класс `MovieService`
Сервис для управления фильмами и их рейтингами.

```java
public class MovieService {
    private final Map<Movie, List<Rating<? extends Number>>> ratings;
    private final double minRating;
    private final double maxRating;
    
    public MovieService() {
        this(1.0, 10.0); // диапазон по умолчанию
    }
    
    public MovieService(double minRating, double maxRating) {
        this.ratings = new ConcurrentHashMap<>();
        this.minRating = minRating;
        this.maxRating = maxRating;
    }
    
    // Основные методы будут реализованы ниже
}
```

---

## Функциональные требования

### 1. Хранение оценок
- Используйте `Map<Movie, List<Rating<? extends Number>>>` для хранения рейтингов.
- Ключ — объект фильма, значение — список оценок для этого фильма.
- Можно использовать `ConcurrentHashMap` для потокобезопасности.

### 2. Добавление оценки
- Метод для добавления оценки к фильму.
- Должен быть **потокобезопасным**.
- Должен **валидировать** оценку на допустимость (в заданном диапазоне, например, от 1 до 10).
- Если оценка некорректна, выбрасывать исключение (например, `IllegalArgumentException`).

```java
public void addRating(Movie movie, Rating<? extends Number> rating) {
    validateRating(rating);
    
    ratings.computeIfAbsent(movie, k -> new CopyOnWriteArrayList<>())
           .add(rating);
}

private void validateRating(Rating<? extends Number> rating) {
    if (rating == null) {
        throw new IllegalArgumentException("Rating cannot be null");
    }
    
    double value = rating.doubleValue();
    if (value < minRating || value > maxRating) {
        throw new IllegalArgumentException(
            String.format("Rating must be between %.1f and %.1f, but was: %.1f", 
                minRating, maxRating, value)
        );
    }
}
```

### 3. Расчёт средней оценки для фильма
- Используйте **Stream API** для подсчёта средней оценки.
- Метод `mapToDouble()` для извлечения числового значения.
- Метод `average()` для расчёта среднего.

```java
public OptionalDouble getAverageRating(Movie movie) {
    List<Rating<? extends Number>> movieRatings = ratings.get(movie);
    
    if (movieRatings == null || movieRatings.isEmpty()) {
        return OptionalDouble.empty();
    }
    
    return movieRatings.stream()
            .mapToDouble(Rating::doubleValue)
            .average();
}
```

### 4. Сортировка фильмов по средней оценке
- Используйте **Stream API** и **лямбда-выражения**.
- Метод `sorted()` с компаратором.
- Возможность сортировки по убыванию (от высоких оценок к низким) или возрастанию.

```java
public List<Movie> getMoviesSortedByAverageRating(boolean descending) {
    return ratings.keySet().stream()
            .map(movie -> new AbstractMap.SimpleEntry<>(movie, getAverageRating(movie)))
            .filter(entry -> entry.getValue().isPresent())
            .sorted((e1, e2) -> {
                Comparator<Double> comparator = Comparator.naturalOrder();
                if (descending) {
                    comparator = comparator.reversed();
                }
                return comparator.compare(
                    e1.getValue().getAsDouble(), 
                    e2.getValue().getAsDouble()
                );
            })
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
}

// Упрощённая версия
public List<Movie> getMoviesSortedByAverageRatingDesc() {
    return ratings.keySet().stream()
            .sorted(Comparator.comparingDouble(
                movie -> getAverageRating(movie).orElse(0.0)
            ).reversed())
            .collect(Collectors.toList());
}
```

### 5. Дополнительные полезные методы

```java
// Получить все фильмы
public Set<Movie> getAllMovies() {
    return ratings.keySet();
}

// Получить все оценки фильма
public List<Rating<? extends Number>> getRatings(Movie movie) {
    return ratings.getOrDefault(movie, Collections.emptyList());
}

// Получить количество оценок для фильма
public int getRatingCount(Movie movie) {
    return ratings.getOrDefault(movie, Collections.emptyList()).size();
}

// Получить фильмы без оценок
public List<Movie> getMoviesWithoutRatings() {
    return ratings.entrySet().stream()
            .filter(entry -> entry.getValue().isEmpty())
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
}
```

---

## Рекомендации по реализации

### 1. Потокобезопасность
Для обеспечения потокобезопасности можно использовать:
- **`ConcurrentHashMap`** для хранения оценок
- **`CopyOnWriteArrayList`** для списков оценок (если добавление происходит часто, но чтение преобладает)
- **Синхронизацию** через `synchronized` для критических секций

```java
private final Map<Movie, List<Rating<? extends Number>>> ratings = new ConcurrentHashMap<>();

public void addRating(Movie movie, Rating<? extends Number> rating) {
    validateRating(rating);
    
    ratings.computeIfAbsent(movie, k -> new CopyOnWriteArrayList<>())
           .add(rating);
}
```

### 2. Валидация оценки
```java
private void validateRating(Rating<? extends Number> rating) {
    if (rating == null || rating.getValue() == null) {
        throw new IllegalArgumentException("Rating and its value cannot be null");
    }
    
    double value = rating.doubleValue();
    if (value < minRating || value > maxRating) {
        throw new IllegalArgumentException(
            "Rating value " + value + " is out of range [" + minRating + ", " + maxRating + "]"
        );
    }
}
```

### 3. Расчёт средней оценки
```java
public double getAverageRatingOrDefault(Movie movie, double defaultValue) {
    return getAverageRating(movie).orElse(defaultValue);
}
```

### 4. Сортировка с учётом количества оценок (продвинутый уровень)
Можно сортировать не только по среднему, но и по количеству оценок (популярности):

```java
public List<Movie> getMoviesSortedByPopularity() {
    return ratings.entrySet().stream()
            .sorted((e1, e2) -> Integer.compare(
                e2.getValue().size(), // по убыванию количества
                e1.getValue().size()
            ))
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
}

// Комбинированная сортировка: сначала по среднему, потом по количеству
public List<Movie> getMoviesSortedByAverageAndCount() {
    return ratings.keySet().stream()
            .sorted((m1, m2) -> {
                double avg1 = getAverageRating(m1).orElse(0.0);
                double avg2 = getAverageRating(m2).orElse(0.0);
                
                if (Math.abs(avg1 - avg2) > 0.001) {
                    return Double.compare(avg2, avg1); // по убыванию среднего
                }
                
                // если среднее примерно равно, то по количеству оценок
                return Integer.compare(
                    getRatingCount(m2), 
                    getRatingCount(m1)
                );
            })
            .collect(Collectors.toList());
}
```

---

## Тестирование

### Что нужно протестировать

1. **Добавление оценок**:
    - Добавление корректной оценки (в диапазоне) → успех.
    - Добавление оценки вне диапазона → исключение.
    - Добавление `null` → исключение.
    - Добавление оценки для нового фильма (автоматическое создание записи).

2. **Расчёт средней оценки**:
    - Для фильма с несколькими оценками → корректное среднее.
    - Для фильма с одной оценкой → среднее равно этой оценке.
    - Для фильма без оценок → `OptionalDouble.empty()`.
    - С разными типами чисел (Integer, Double, Float).

3. **Сортировка фильмов**:
    - Пустой список → пустой результат.
    - Несколько фильмов с разными средними → правильный порядок.
    - Фильмы с одинаковым средним (можно тестировать стабильность сортировки).

4. **Потокобезопасность**:
    - Одновременное добавление оценок из нескольких потоков.
    - Одновременное добавление и чтение (расчёт среднего, сортировка).

### Пример тестов (JUnit)

```java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.concurrent.*;

public class MovieServiceTest {
    private MovieService movieService;
    private Movie movie1;
    private Movie movie2;
    
    @BeforeEach
    public void setUp() {
        movieService = new MovieService(1.0, 10.0);
        movie1 = new Movie("Inception", 2010, "Christopher Nolan");
        movie2 = new Movie("The Matrix", 1999, "Wachowski Brothers");
    }
    
    @Test
    public void testAddValidRating() {
        Rating<Integer> rating = new Rating<>(8);
        movieService.addRating(movie1, rating);
        
        assertEquals(8.0, movieService.getAverageRating(movie1).getAsDouble());
        assertEquals(1, movieService.getRatingCount(movie1));
    }
    
    @Test
    public void testAddRatingOutOfRangeThrowsException() {
        Rating<Integer> rating = new Rating<>(11);
        
        assertThrows(IllegalArgumentException.class, 
            () -> movieService.addRating(movie1, rating));
    }
    
    @Test
    public void testAddNullRatingThrowsException() {
        assertThrows(IllegalArgumentException.class, 
            () -> movieService.addRating(movie1, null));
    }
    
    @Test
    public void testAverageRatingWithMultipleRatings() {
        movieService.addRating(movie1, new Rating<>(8));
        movieService.addRating(movie1, new Rating<>(9));
        movieService.addRating(movie1, new Rating<>(7));
        
        OptionalDouble avg = movieService.getAverageRating(movie1);
        assertTrue(avg.isPresent());
        assertEquals(8.0, avg.getAsDouble(), 0.001);
    }
    
    @Test
    public void testAverageRatingWithNoRatings() {
        OptionalDouble avg = movieService.getAverageRating(movie1);
        assertFalse(avg.isPresent());
    }
    
    @Test
    public void testSortingMoviesByAverageRating() {
        movieService.addRating(movie1, new Rating<>(9));
        movieService.addRating(movie1, new Rating<>(10)); // среднее 9.5
        
        movieService.addRating(movie2, new Rating<>(7));
        movieService.addRating(movie2, new Rating<>(8)); // среднее 7.5
        
        List<Movie> sorted = movieService.getMoviesSortedByAverageRatingDesc();
        
        assertEquals(2, sorted.size());
        assertEquals(movie1, sorted.get(0)); // первый с более высоким рейтингом
        assertEquals(movie2, sorted.get(1));
    }
    
    @Test
    public void testConcurrentAddRatings() throws InterruptedException, ExecutionException {
        int threadCount = 10;
        int ratingsPerThread = 100;
        
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        CountDownLatch latch = new CountDownLatch(threadCount);
        
        for (int t = 0; t < threadCount; t++) {
            executor.submit(() -> {
                try {
                    for (int i = 0; i < ratingsPerThread; i++) {
                        movieService.addRating(movie1, new Rating<>(8));
                    }
                } finally {
                    latch.countDown();
                }
            });
        }
        
        latch.await();
        executor.shutdown();
        
        assertEquals(threadCount * ratingsPerThread, 
                movieService.getRatingCount(movie1));
        
        OptionalDouble avg = movieService.getAverageRating(movie1);
        assertTrue(avg.isPresent());
        assertEquals(8.0, avg.getAsDouble(), 0.001);
    }
    
    @Test
    public void testDifferentRatingTypes() {
        movieService.addRating(movie1, new Rating<>(8)); // Integer
        movieService.addRating(movie1, new Rating<>(9.5)); // Double
        movieService.addRating(movie1, new Rating<>(7.5f)); // Float
        
        OptionalDouble avg = movieService.getAverageRating(movie1);
        assertTrue(avg.isPresent());
        assertEquals(8.333, avg.getAsDouble(), 0.001);
    }
}
```

---

## Пример использования

```java
public class Main {
    public static void main(String[] args) {
        // Создаём сервис с диапазоном оценок от 1 до 10
        MovieService movieService = new MovieService(1, 10);
        
        // Создаём фильмы
        Movie inception = new Movie("Inception", 2010, "Christopher Nolan");
        Movie matrix = new Movie("The Matrix", 1999, "Wachowski Brothers");
        Movie interstellar = new Movie("Interstellar", 2014, "Christopher Nolan");
        
        // Добавляем оценки (разные типы)
        movieService.addRating(inception, new Rating<>(9)); // Integer
        movieService.addRating(inception, new Rating<>(8.5)); // Double
        movieService.addRating(inception, new Rating<>(10)); // Integer
        
        movieService.addRating(matrix, new Rating<>(8));
        movieService.addRating(matrix, new Rating<>(9));
        
        movieService.addRating(interstellar, new Rating<>(7));
        movieService.addRating(interstellar, new Rating<>(8.5));
        movieService.addRating(interstellar, new Rating<>(9.0));
        
        // Выводим средние оценки
        System.out.println("=== Средние оценки ===");
        printAverageRating(movieService, inception);
        printAverageRating(movieService, matrix);
        printAverageRating(movieService, interstellar);
        
        // Сортируем фильмы по среднему рейтингу (по убыванию)
        System.out.println("\n=== Фильмы, отсортированные по рейтингу ===");
        List<Movie> sortedMovies = movieService.getMoviesSortedByAverageRatingDesc();
        for (int i = 0; i < sortedMovies.size(); i++) {
            Movie movie = sortedMovies.get(i);
            double avg = movieService.getAverageRating(movie).orElse(0.0);
            System.out.printf("%d. %s (%.2f) - %d оценок\n", 
                i + 1, movie.getTitle(), avg, movieService.getRatingCount(movie));
        }
        
        // Демонстрация потокобезопасности
        System.out.println("\n=== Многопоточное добавление оценок ===");
        // В реальном коде здесь можно запустить несколько потоков
    }
    
    private static void printAverageRating(MovieService service, Movie movie) {
        OptionalDouble avg = service.getAverageRating(movie);
        if (avg.isPresent()) {
            System.out.printf("%s: %.2f (%d оценок)\n", 
                movie.getTitle(), avg.getAsDouble(), service.getRatingCount(movie));
        } else {
            System.out.printf("%s: нет оценок\n", movie.getTitle());
        }
    }
}
```

Вывод:
```
=== Средние оценки ===
Inception: 9.17 (3 оценок)
The Matrix: 8.50 (2 оценок)
Interstellar: 8.17 (3 оценок)

=== Фильмы, отсортированные по рейтингу ===
1. Inception (9.17) - 3 оценок
2. The Matrix (8.50) - 2 оценок
3. Interstellar (8.17) - 3 оценок
```

---
