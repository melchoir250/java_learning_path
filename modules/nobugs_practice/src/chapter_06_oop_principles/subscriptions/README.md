---

# Задача: Учёт подписки на сервис (Полиморфизм через поведение)

## Описание
Создание системы управления подписками с разными уровнями доступа. Задача демонстрирует **полиморфизм через поведение**: все типы подписок имеют одинаковый интерфейс с методом `canAccess()`, но реализуют проверку доступа по-разному, в зависимости от своего тарифа.

## Условие
1.  Создайте **интерфейс** (или абстрактный класс) `Subscription` с методом `boolean canAccess(String featureName)`.
2.  Реализуйте три класса подписок:
    *   **`Basic`** — базовая подписка. Доступны только базовые функции (например, "watch_sd", "basic_support").
    *   **`Premium`** — премиум-подписка. Доступны все функции, включая премиальные (например, "watch_4k", "exclusive_content", "priority_support").
    *   **`Family`** — семейная подписка. Доступны почти все функции, как у Premium, но с возможностью добавления нескольких пользователей (для простоты можно просто дать доступ к функциям Premium плюс специальная функция "family_sharing").
3.  Создайте класс **`User`**:
    *   Поля: `String name`, `Subscription subscription`.
    *   Конструктор, геттеры/сеттеры.
    *   Метод `void changeSubscription(Subscription newSubscription)` — позволяет сменить тариф.
    *   Метод `boolean hasAccess(String feature)` — делегирует проверку текущей подписке (`subscription.canAccess(feature)`).
4.  В методе `main` продемонстрируйте:
    *   Создание пользователя с разными типами подписок.
    *   Проверку доступа к различным функциям.
    *   Смену подписки и повторную проверку доступа.

## Пояснение
Полиморфизм позволяет нам работать с разными типами подписок через единый интерфейс `Subscription`. Класс `User` ничего не знает о внутренней логике проверки доступа в `Basic`, `Premium` или `Family`. Он просто вызывает `subscription.canAccess(featureName)`, а конкретная реализация сама определяет, есть ли доступ. Это делает систему гибкой: можно добавлять новые типы подписок, не изменяя класс `User`.

## Пример кода (структура)

```java
import java.util.Set;

// Интерфейс подписки
interface Subscription {
    boolean canAccess(String featureName);
}

// Базовая подписка
class Basic implements Subscription {
    private Set<String> allowedFeatures = Set.of("watch_sd", "basic_support");

    @Override
    public boolean canAccess(String featureName) {
        return allowedFeatures.contains(featureName);
    }
}

// Премиум-подписка
class Premium implements Subscription {
    private Set<String> allowedFeatures = Set.of(
        "watch_sd", "watch_hd", "watch_4k", 
        "basic_support", "priority_support", 
        "exclusive_content"
    );

    @Override
    public boolean canAccess(String featureName) {
        return allowedFeatures.contains(featureName);
    }
}

// Семейная подписка (расширяет Premium, добавляя семейные функции)
class Family extends Premium {
    private Set<String> familyFeatures = Set.of("family_sharing", "parental_controls");

    @Override
    public boolean canAccess(String featureName) {
        // Имеет доступ ко всем функциям Premium плюс семейным
        return super.canAccess(featureName) || familyFeatures.contains(featureName);
    }
}

// Класс пользователя
class User {
    private String name;
    private Subscription subscription;

    public User(String name, Subscription subscription) {
        this.name = name;
        this.subscription = subscription;
    }

    public void changeSubscription(Subscription newSubscription) {
        this.subscription = newSubscription;
        System.out.println(name + " сменил подписку на " + newSubscription.getClass().getSimpleName());
    }

    public boolean hasAccess(String feature) {
        return subscription.canAccess(feature);
    }

    public String getName() {
        return name;
    }
}

// Демонстрация
public class Main {
    public static void main(String[] args) {
        // Создаём пользователя с базовой подпиской
        User user = new User("Анна", new Basic());
        
        // Проверяем доступ к функциям
        checkAccess(user, "watch_4k");
        checkAccess(user, "watch_sd");
        
        // Переходим на премиум
        user.changeSubscription(new Premium());
        checkAccess(user, "watch_4k");
        checkAccess(user, "exclusive_content");
        
        // Переходим на семейную
        user.changeSubscription(new Family());
        checkAccess(user, "family_sharing");
        checkAccess(user, "watch_4k");
    }
    
    private static void checkAccess(User user, String feature) {
        System.out.println(user.getName() + " имеет доступ к '" + feature + "': " + user.hasAccess(feature));
    }
}
```

## Ключевые моменты реализации

*   **Единый интерфейс**: Все подписки реализуют `Subscription`, что гарантирует наличие метода `canAccess()`.
*   **Делегирование**: Пользователь делегирует проверку доступа своей текущей подписке, следуя принципу "композиция вместо наследования".
*   **Наследование для расширения**: Класс `Family` может наследовать от `Premium`, чтобы переиспользовать логику проверки премиум-функций и добавить свои.
*   **Гибкость смены тарифа**: Метод `changeSubscription()` позволяет динамически менять поведение пользователя (полиморфизм в действии).

## Ожидаемый результат

При запуске программы мы увидим, как меняется доступ пользователя к функциям при смене типа подписки:

```
Анна имеет доступ к 'watch_4k': false
Анна имеет доступ к 'watch_sd': true
Анна сменил подписку на Premium
Анна имеет доступ к 'watch_4k': true
Анна имеет доступ к 'exclusive_content': true
Анна сменил подписку на Family
Анна имеет доступ к 'family_sharing': true
Анна имеет доступ к 'watch_4k': true
```
