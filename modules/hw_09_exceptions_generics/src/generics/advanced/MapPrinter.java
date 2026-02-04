package generics.advanced;

// Создайте Map<K, V> и реализуйте метод, который принимает обобщённые ключи и значения, а затем выводит их.

// Объявите метод как public static <K, V> void printMap(Map<K, V> map)
// Используйте цикл for (Map.Entry<K, V> entry : map.entrySet())
// Выводите каждый ключ и значение с помощью System.out.println()
// В main() протестируйте с разными типами данных, например, Map<String, Integer>

import java.util.Map;

public class MapPrinter<K, V> {
    public static <K, V> void printMap(Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println(
                    "Key: " + entry.getKey() + ", Value: " + entry.getValue()
            );
        }
    }
}
