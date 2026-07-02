# Задача 1: Библиотека для сокращения URL

## Описание

Разработать библиотеку, которая предоставляет функциональность для сокращения длинных URL и их восстановления.
Библиотека должна быть гибкой, чтобы в будущем можно было легко добавлять новые методы сокращения.

## Паттерны проектирования

| Паттерн | Назначение |
|---------|------------|
| **Singleton** | Единственное хранилище всех URL |
| **Factory Method** | Создание объектов, отвечающих за различные методы сокращения URL |
| **Strategy** | Переключение между способами сокращения URL |

## Архитектура библиотеки

| Компонент | Описание |
|-----------|----------|
| `UrlShortenerService` | Класс, отвечающий за логику сокращения и восстановления URL |
| `UrlStorage` | Интерфейс для хранения пар «длинный URL — короткий URL». Реализации: память, файлы, база данных и т.д. |
| `ShorteningStrategy` | Интерфейс с методом сокращения URL. Реализации: Base62, хеширование, UUID и другие |
| `ShortenerFactory` | Фабрика (Factory Method) для создания объектов `ShorteningStrategy` |

## Требования

1. **`UrlStorage`**: интерфейс хранилища с реализацией in-memory (Singleton)
2. **`ShorteningStrategy`**: интерфейс стратегии с минимум одной реализацией (`Base62Strategy`)
3. **`ShortenerFactory`**: фабрика для создания стратегий сокращения
4. **`UrlShortenerService`**: методы `shortenUrl(String longUrl)` и `expandUrl(String shortUrl)`

## Пример использования

```java
// Конфигурация библиотеки с выбранной стратегией сокращения
ShorteningStrategy strategy = ShortenerFactory.create(StrategyType.BASE62);
UrlShortenerService shortenerService = new UrlShortenerService(strategy);

// Сокращение URL
String shortUrl = shortenerService.shortenUrl("https://example.com/very/long/url");
System.out.println("Short URL: " + shortUrl);

// Восстановление URL
String longUrl = shortenerService.expandUrl(shortUrl);
System.out.println("Original URL: " + longUrl);
```
