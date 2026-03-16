---

# Задача: Информация о книгах (Инкапсуляция + Связанность)

## Описание
Создание системы для хранения и поиска информации о книгах. Задача демонстрирует принцип **инкапсуляции** — данные книги (название, автор, год) скрыты от прямого доступа и доступны только через методы-геттеры. Класс `Library` выступает в роли контейнера, который управляет коллекцией книг и предоставляет удобный интерфейс для добавления и поиска, что показывает хорошую **связанность** (каждый класс отвечает за свою область ответственности).

## Условие
1.  Создайте класс **`Book`**:
    *   Приватные поля: `String title` (название), `String author` (автор), `int year` (год издания).
    *   Конструктор для инициализации всех полей.
    *   Публичные методы-геттеры для каждого поля (`getTitle()`, `getAuthor()`, `getYear()`).
    *   (Опционально) Метод `toString()` для удобного вывода информации о книге.
2.  Создайте класс **`Library`**:
    *   Приватное поле `private List<Book> books` (список книг).
    *   Метод `void addBook(Book book)` — добавляет книгу в библиотеку.
    *   Метод `List<Book> searchByAuthor(String author)` — возвращает список книг указанного автора.
    *   Метод `List<Book> searchByYear(int year)` — возвращает список книг, изданных в указанном году.
    *   Метод `List<Book> searchByYearRange(int fromYear, int toYear)` — возвращает книги, изданные в диапазоне лет.
    *   Метод `void displayAllBooks()` — выводит информацию обо всех книгах в библиотеке.
3.  В методе `main` продемонстрируйте:
    *   Создание нескольких книг.
    *   Добавление их в библиотеку.
    *   Поиск книг по автору.
    *   Поиск книг по году.
    *   Поиск книг по диапазону годов.
    *   Вывод всех книг.

## Пояснение
**Инкапсуляция** обеспечивается тем, что поля класса `Book` объявлены как `private`, и доступ к ним возможен только через публичные методы `get...()`. Это позволяет в будущем изменить внутреннее представление данных (например, хранить год как `String` или добавить валидацию) без изменения кода, который использует класс `Book`.

**Связанность** (высокая когезия) означает, что каждый класс отвечает за чётко определённую задачу: `Book` — за хранение данных о книге, `Library` — за управление коллекцией и поиск. Методы библиотеки предоставляют удобный интерфейс для работы с книгами, скрывая детали реализации (например, то, что книги хранятся в `ArrayList`).

## Пример кода (структура)

```java
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Класс Книга с инкапсулированными данными
class Book {
    private String title;
    private String author;
    private int year;
    
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }
    
    // Геттеры — единственный способ получить доступ к данным
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public int getYear() {
        return year;
    }
    
    // Для удобного вывода информации о книге
    @Override
    public String toString() {
        return String.format("\"%s\" %s (%d)", title, author, year);
    }
}

// Класс Библиотека — управляет коллекцией книг и поиском
class Library {
    private List<Book> books;
    
    public Library() {
        books = new ArrayList<>();
    }
    
    // Добавление книги
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Добавлена книга: " + book);
    }
    
    // Поиск по автору
    public List<Book> searchByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }
    
    // Поиск по точному году
    public List<Book> searchByYear(int year) {
        return books.stream()
                .filter(book -> book.getYear() == year)
                .collect(Collectors.toList());
    }
    
    // Поиск по диапазону лет
    public List<Book> searchByYearRange(int fromYear, int toYear) {
        return books.stream()
                .filter(book -> book.getYear() >= fromYear && book.getYear() <= toYear)
                .collect(Collectors.toList());
    }
    
    // Вывод всех книг
    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("Библиотека пуста.");
            return;
        }
        System.out.println("\nВсе книги в библиотеке:");
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
    }
    
    // Получение количества книг
    public int getBookCount() {
        return books.size();
    }
}

// Демонстрация
public class Main {
    public static void main(String[] args) {
        // Создаём библиотеку
        Library library = new Library();
        
        // Создаём книги (данные инкапсулированы)
        Book book1 = new Book("Война и мир", "Лев Толстой", 1869);
        Book book2 = new Book("Анна Каренина", "Лев Толстой", 1877);
        Book book3 = new Book("Преступление и наказание", "Фёдор Достоевский", 1866);
        Book book4 = new Book("Идиот", "Фёдор Достоевский", 1869);
        Book book5 = new Book("Мастер и Маргарита", "Михаил Булгаков", 1967);
        Book book6 = new Book("Собачье сердце", "Михаил Булгаков", 1925);
        
        // Добавляем книги в библиотеку
        System.out.println("=== Добавление книг ===");
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
        library.addBook(book6);
        
        // Выводим все книги
        library.displayAllBooks();
        
        // Поиск по автору
        System.out.println("\n=== Поиск книг Льва Толстого ===");
        List<Book> tolstoyBooks = library.searchByAuthor("Лев Толстой");
        printSearchResult(tolstoyBooks, "Найдено книг Льва Толстого: " + tolstoyBooks.size());
        
        // Поиск по году
        System.out.println("\n=== Поиск книг 1869 года ===");
        List<Book> books1869 = library.searchByYear(1869);
        printSearchResult(books1869, "Книги 1869 года:");
        
        // Поиск по диапазону лет
        System.out.println("\n=== Поиск книг с 1860 по 1870 год ===");
        List<Book> books1860to1870 = library.searchByYearRange(1860, 1870);
        printSearchResult(books1860to1870, "Книги 1860-1870 годов:");
        
        // Демонстрация, что прямой доступ к полям невозможен
        System.out.println("\n=== Демонстрация инкапсуляции ===");
        System.out.println("Книга: " + book1.getTitle() + ", автор: " + book1.getAuthor() + 
                          ", год: " + book1.getYear());
        // Следующая строка не скомпилируется, так как поля private:
        // System.out.println(book1.title); // Ошибка компиляции!
    }
    
    // Вспомогательный метод для вывода результатов поиска
    private static void printSearchResult(List<Book> books, String message) {
        System.out.println(message);
        if (books.isEmpty()) {
            System.out.println("  Ничего не найдено.");
        } else {
            for (Book book : books) {
                System.out.println("  " + book);
            }
        }
    }
}
```

## Ключевые моменты реализации

*   **Приватные поля**: Все поля класса `Book` объявлены как `private` — прямой доступ извне невозможен.
*   **Геттеры**: Публичные методы `getTitle()`, `getAuthor()`, `getYear()` — единственный способ получить данные книги.
*   **Отсутствие сеттеров**: В данной задаче книги неизменяемы после создания (иммутабельность), что упрощает работу и предотвращает случайные изменения.
*   **Инкапсуляция коллекции**: Поле `books` в классе `Library` тоже приватное. Внешний код не может напрямую получить доступ к списку и изменить его.
*   **Чистые методы поиска**: Методы поиска не изменяют состояние библиотеки, а только возвращают новые списки, соответствующие критериям.
*   **Использование Stream API**: Для краткости и читаемости кода поиска использованы стримы, но можно реализовать и обычными циклами.

## Ожидаемый результат

При запуске программы мы увидим, как создаются книги, добавляются в библиотеку, и как работает поиск по разным критериям:

```
=== Добавление книг ===
Добавлена книга: "Война и мир" Лев Толстой (1869)
Добавлена книга: "Анна Каренина" Лев Толстой (1877)
Добавлена книга: "Преступление и наказание" Фёдор Достоевский (1866)
Добавлена книга: "Идиот" Фёдор Достоевский (1869)
Добавлена книга: "Мастер и Маргарита" Михаил Булгаков (1967)
Добавлена книга: "Собачье сердце" Михаил Булгаков (1925)

Все книги в библиотеке:
1. "Война и мир" Лев Толстой (1869)
2. "Анна Каренина" Лев Толстой (1877)
3. "Преступление и наказание" Фёдор Достоевский (1866)
4. "Идиот" Фёдор Достоевский (1869)
5. "Мастер и Маргарита" Михаил Булгаков (1967)
6. "Собачье сердце" Михаил Булгаков (1925)

=== Поиск книг Льва Толстого ===
Найдено книг Льва Толстого: 2
  "Война и мир" Лев Толстой (1869)
  "Анна Каренина" Лев Толстой (1877)

=== Поиск книг 1869 года ===
Книги 1869 года:
  "Война и мир" Лев Толстой (1869)
  "Идиот" Фёдор Достоевский (1869)

=== Поиск книг с 1860 по 1870 год ===
Книги 1860-1870 годов:
  "Война и мир" Лев Толстой (1869)
  "Преступление и наказание" Фёдор Достоевский (1866)
  "Идиот" Фёдор Достоевский (1869)
```
