---

# Задача 10: ConcurrentModificationException при удалении из списка

## Описание
Программа должна удалить из списка все имена, начинающиеся с буквы "A". Однако при запуске выбрасывается исключение `ConcurrentModificationException`. Ваша задача — с помощью отладчика найти причину ошибки и исправить код.

## Условие
```java
import java.util.*;

public class DebugTask10 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie"));
        for (String name : names) {
            if (name.startsWith("A")) {
                names.remove(name);
            }
        }
    }
}
```

## Ожидаемый результат
Программа должна удалить имя "Alice" из списка и успешно завершиться. После выполнения в списке должны остаться:
```
["Bob", "Charlie"]
```

## Фактическое поведение
При запуске программа выбрасывает исключение:
```
Exception in thread "main" java.util.ConcurrentModificationException
    at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1013)
    at java.base/java.util.ArrayList$Itr.next(ArrayList.java:967)
    at DebugTask10.main(DebugTask10.java:6)
```

## Задание
1. Запустите программу в режиме отладки (Debug).
2. Установите точку останова (breakpoint) внутри цикла `for-each`.
3. Проанализируйте выполнение программы на каждой итерации.
4. Обратите внимание на состояние списка и итератора после удаления элемента.
5. Найдите причину возникновения исключения.
6. Исправьте код так, чтобы он работал согласно ожиданию.
7. Запишите процесс отладки и исправления на видео.

## Подсказки для отладки
- Обратите внимание на то, что цикл `for-each` использует итератор под капотом.
- Проверьте, что происходит с итератором, когда вы модифицируете список во время итерации.
- Подумайте, какие существуют способы безопасного удаления элементов из коллекции во время обхода.