---

### 8. Онлайн-курс и абстракция типов уроков (Абстракция + Полиморфизм)

```markdown
# Задача 8: Онлайн-курс и абстракция типов уроков

## Описание
Моделирование структуры онлайн-курса, состоящего из уроков разных типов. Задача учит использовать абстракцию для работы с коллекцией разнородных объектов, не вдаваясь в их конкретные детали.

## Условие
1.  Создайте **абстрактный класс** `Lesson` с методами:
    *   `String getTitle()` — возвращает название урока.
    *   `int getDuration()` — возвращает длительность урока в минутах.
2.  Реализуйте трех наследников с разной внутренней логикой (можно добавить свои поля):
    *   `VideoLesson` (длительность видео).
    *   `LiveSession` (время начала и конца).
    *   `HomeworkLesson` (время на выполнение).
3.  Создайте метод `calculateTotalDuration(Lesson[] lessons)`, который принимает список уроков и печатает общее время прохождения всего курса.

## Пояснение
Мы не знаем, как устроены внутри `LiveSession` или `HomeworkLesson`, но благодаря абстракции мы можем быть уверены, что у каждого из них есть метод `getDuration()`. Это позволяет легко подсчитать общую сумму.

## Пример кода (структура)
```java
abstract class Lesson {
    private String title;
    public Lesson(String title) { this.title = title; }
    public String getTitle() { return title; }
    public abstract int getDuration();
}

class VideoLesson extends Lesson {
    private int videoLength;
    // ...
    @Override
    public int getDuration() {
        return videoLength; // Длительность равна длине видео
    }
}

class LiveSession extends Lesson {
    private int startTime, endTime;
    // ...
    @Override
    public int getDuration() {
        return endTime - startTime; // Вычисляем разницу
    }
}

// Демонстрация
public class Main {
    public static void calculateTotalDuration(Lesson[] lessons) {
        int total = 0;
        for (Lesson lesson : lessons) {
            total += lesson.getDuration();
        }
        System.out.println("Общая длительность курса: " + total + " мин.");
    }
}