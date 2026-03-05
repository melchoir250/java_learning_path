---

### 9. Игровой объект и абстрактное поведение (Интерфейс + Полиморфизм)

```markdown
# Задача 9: Игровой объект и абстрактное поведение

## Описание
Создание простого игрового движка, основанного на полиморфизме. Разные игровые объекты по-разному ведут себя при обновлении состояния (`update`) и отрисовке (`render`), что является классическим примером полиморфного поведения в геймдизайне.

## Условие
1.  Создайте **интерфейс** `GameObject` с методами:
    *   `void update()` — обновление состояния (логика).
    *   `void render()` — отрисовка на экране (вывод в консоль).
2.  Реализуйте несколько классов:
    *   `Player` (реагирует на нажатия клавиш).
    *   `Enemy` (движется к игроку).
    *   `CollectibleItem` (вращается и ждет, пока игрок его подберет).
3.  Создайте игровой цикл (в методе `main`), который хранит список `List<GameObject>` и на каждой итерации (для простоты можно сделать один проход) вызывает у каждого объекта методы `update()` и `render()`.

## Пояснение
Главный игровой цикл ничего не знает о том, является ли объект врагом или предметом. Он просто знает, что это `GameObject`, и вызывает его методы. Конкретное поведение определяет сам объект.

## Пример кода (структура)
```java
interface GameObject {
    void update();
    void render();
}

class Player implements GameObject {
    private int health = 100;
    @Override
    public void update() {
        // Логика: проверка нажатий клавиш
    }
    @Override
    public void render() {
        System.out.println("Отрисовка игрока. Здоровье: " + health);
    }
}

class Enemy implements GameObject {
    private int x = 0;
    @Override
    public void update() {
        x++; // Движение врага
    }
    @Override
    public void render() {
        System.out.println("Отрисовка врага на позиции: " + x);
    }
}

// Демонстрация (игровой цикл)
import java.util.*;

public class GameLoop {
    public static void main(String[] args) {
        List<GameObject> objects = Arrays.asList(new Player(), new Enemy());

        // Один тик игры
        for (GameObject obj : objects) {
            obj.update();
            obj.render();
            System.out.println("---");
        }
    }
}