---

# Задача 2: Валидатор пользовательских данных (User Validator)

## Описание
Разработайте систему валидации для модели данных пользователя, которая проверяет корректность имени, возраста и электронной почты. Валидация должна управляться через глобальный флаг `validationEnabled`, который может быть включен или выключен. Если данные не проходят валидацию, должно выбрасываться специализированное исключение `InvalidUserException`.

## Модель данных

### Класс `User`
Класс пользователя с атрибутами для имени, возраста и электронной почты.

```java
public class User {
    private String name;
    private int age;
    private String email;
    
    public User(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
    
    // Геттеры и сеттеры
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
```

## Класс валидатора

### `UserValidator`
Сервис, который предоставляет методы для проверки объектов `User` на соответствие определённым правилам.

```java
public class UserValidator {
    private boolean validationEnabled = true;
    
    // Конструкторы, геттеры и сеттеры для флага
    public UserValidator() {}
    
    public UserValidator(boolean validationEnabled) {
        this.validationEnabled = validationEnabled;
    }
    
    public boolean isValidationEnabled() {
        return validationEnabled;
    }
    
    public void setValidationEnabled(boolean validationEnabled) {
        this.validationEnabled = validationEnabled;
    }
    
    // Основной метод валидации
    public void validate(User user) throws InvalidUserException {
        if (!validationEnabled) {
            return; // Валидация отключена
        }
        
        if (user == null) {
            throw new InvalidUserException("User object is null");
        }
        
        validateName(user.getName());
        validateAge(user.getAge());
        validateEmail(user.getEmail());
    }
    
    // Отдельные методы для каждой проверки
    private void validateName(String name) throws InvalidUserException {
        // Реализация проверки имени
    }
    
    private void validateAge(int age) throws InvalidUserException {
        // Реализация проверки возраста
    }
    
    private void validateEmail(String email) throws InvalidUserException {
        // Реализация проверки email
    }
}
```

### `InvalidUserException`
Специализированное исключение для ошибок валидации.

```java
public class InvalidUserException extends Exception {
    public InvalidUserException(String message) {
        super(message);
    }
    
    public InvalidUserException(String message, Throwable cause) {
        super(message, cause);
    }
}
```

## Функциональные требования

### 1. Проверка имени
- Имя должно быть **не пустым** (не `null` и не пустая строка после trim).
- Имя должно **начинаться с заглавной буквы** (первый символ — буква в верхнем регистре).
- *(Опционально)* Имя может содержать только буквы и пробелы.

**Пример реализации:**
```java
private void validateName(String name) throws InvalidUserException {
    if (name == null || name.trim().isEmpty()) {
        throw new InvalidUserException("Name cannot be empty");
    }
    
    char firstChar = name.trim().charAt(0);
    if (!Character.isUpperCase(firstChar)) {
        throw new InvalidUserException("Name must start with an uppercase letter");
    }
    
    // Дополнительная проверка: только буквы и пробелы
    if (!name.matches("[a-zA-Z\\s]+")) {
        throw new InvalidUserException("Name can only contain letters and spaces");
    }
}
```

### 2. Проверка возраста
- Возраст должен быть в пределах от **18 до 100 лет** включительно.

**Пример реализации:**
```java
private void validateAge(int age) throws InvalidUserException {
    if (age < 18 || age > 100) {
        throw new InvalidUserException("Age must be between 18 and 100 (inclusive)");
    }
}
```

### 3. Проверка email
- Email должен соответствовать стандартному формату электронной почты.
- Рекомендуется использовать **регулярное выражение**, которое проверяет:
    - Наличие символа `@`
    - Наличие домена после `@`
    - Корректную структуру (локальная часть, домен, точка в домене)

**Пример регулярного выражения для email:**
```java
private static final String EMAIL_REGEX = 
    "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

private void validateEmail(String email) throws InvalidUserException {
    if (email == null || email.trim().isEmpty()) {
        throw new InvalidUserException("Email cannot be empty");
    }
    
    if (!email.matches(EMAIL_REGEX)) {
        throw new InvalidUserException("Invalid email format");
    }
}
```

### 4. Управление валидацией
- Валидация данных должна происходить **только если флаг `validationEnabled` установлен в `true`**.
- Флаг может быть установлен через конструктор или сеттер.
- По умолчанию валидация **включена**.

**Пример использования:**
```java
UserValidator validator = new UserValidator(); // Валидация включена по умолчанию
validator.setValidationEnabled(false); // Отключить валидацию
```

### 5. Исключения
- При обнаружении невалидных данных необходимо выбрасывать `InvalidUserException`.
- Исключение должно быть **информативным** и указывать на конкретную ошибку.
- Можно выбрасывать исключение при первой же ошибке или собирать все ошибки (продвинутый уровень).

## Ключевые темы
- **Классы и объекты**: Модель данных `User` и сервис `UserValidator`.
- **Регулярные выражения**: Для валидации email.
- **Пользовательские исключения**: Создание и использование `InvalidUserException`.
- **Условная логика**: Управление валидацией через флаг.
- **Тестирование**: Проверка различных сценариев валидации.

## Рекомендации по реализации

### Управление валидацией
```java
public void validate(User user) throws InvalidUserException {
    if (!validationEnabled) {
        System.out.println("Validation is disabled, skipping checks");
        return;
    }
    // ... проверки
}
```

### Сбор всех ошибок (продвинутый уровень)
Вместо выброса исключения при первой ошибке можно собрать все ошибки и выбросить одно исключение со списком:

```java
public void validate(User user) throws InvalidUserException {
    if (!validationEnabled) return;
    
    List<String> errors = new ArrayList<>();
    
    try { validateName(user.getName()); } 
    catch (InvalidUserException e) { errors.add(e.getMessage()); }
    
    try { validateAge(user.getAge()); } 
    catch (InvalidUserException e) { errors.add(e.getMessage()); }
    
    try { validateEmail(user.getEmail()); } 
    catch (InvalidUserException e) { errors.add(e.getMessage()); }
    
    if (!errors.isEmpty()) {
        throw new InvalidUserException("Validation failed: " + String.join("; ", errors));
    }
}
```

## Тестирование

### Что нужно протестировать

1. **Валидация имени**:
    - Пустое имя (`null`, `""`, `"   "`) → исключение
    - Имя с маленькой буквы (`"alice"`) → исключение
    - Корректное имя (`"Alice"`, `"Alice Smith"`) → успех

2. **Валидация возраста**:
    - Возраст меньше 18 (17, 0, отрицательный) → исключение
    - Возраст больше 100 (101, 150) → исключение
    - Граничные значения (18, 100) → успех
    - Корректный возраст (25, 33, 50) → успех

3. **Валидация email**:
    - Пустой email → исключение
    - Email без `@` → исключение
    - Email без домена (`"user@"`) → исключение
    - Email с некорректным доменом (`"user@domain"` без точки) → исключение (зависит от регулярки)
    - Корректный email (`"user@example.com"`, `"user.name@domain.co.uk"`) → успех

4. **Управление валидацией**:
    - При `validationEnabled = true` проверки выполняются.
    - При `validationEnabled = false` проверки пропускаются (даже для невалидных данных).

5. **Null-объект User**:
    - Передача `null` в `validate()` → исключение.

### Пример тестов (JUnit)

```java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserValidatorTest {
    private UserValidator validator;
    
    @BeforeEach
    public void setUp() {
        validator = new UserValidator();
    }
    
    @Test
    public void testValidUser() throws InvalidUserException {
        User user = new User("Alice", 25, "alice@example.com");
        assertDoesNotThrow(() -> validator.validate(user));
    }
    
    @Test
    public void testInvalidName() {
        User user = new User("alice", 25, "alice@example.com");
        assertThrows(InvalidUserException.class, () -> validator.validate(user));
    }
    
    @Test
    public void testInvalidAge() {
        User user = new User("Alice", 17, "alice@example.com");
        assertThrows(InvalidUserException.class, () -> validator.validate(user));
    }
    
    @Test
    public void testInvalidEmail() {
        User user = new User("Alice", 25, "invalid-email");
        assertThrows(InvalidUserException.class, () -> validator.validate(user));
    }
    
    @Test
    public void testValidationDisabled() throws InvalidUserException {
        validator.setValidationEnabled(false);
        User user = new User("alice", 17, "invalid-email");
        assertDoesNotThrow(() -> validator.validate(user)); // Валидация отключена
    }
    
    @Test
    public void testNullUser() {
        assertThrows(InvalidUserException.class, () -> validator.validate(null));
    }
}
```

## Пример использования

```java
public class Main {
    public static void main(String[] args) {
        // Создаём валидатор (по умолчанию включён)
        UserValidator validator = new UserValidator();
        
        // Создаём пользователей
        User validUser = new User("Alice", 25, "alice@example.com");
        User invalidNameUser = new User("bob", 30, "bob@example.com");
        User invalidAgeUser = new User("Charlie", 17, "charlie@example.com");
        User invalidEmailUser = new User("Diana", 28, "diana@invalid");
        
        // Валидация с проверками
        try {
            validator.validate(validUser);
            System.out.println("Valid user passed validation");
        } catch (InvalidUserException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        try {
            validator.validate(invalidNameUser);
        } catch (InvalidUserException e) {
            System.out.println("Error for invalid name: " + e.getMessage());
        }
        
        // Отключаем валидацию
        validator.setValidationEnabled(false);
        
        try {
            validator.validate(invalidAgeUser); // Не выбросит исключение
            System.out.println("Validation disabled, invalid age user accepted");
        } catch (InvalidUserException e) {
            // Не произойдёт
        }
    }
}
```
