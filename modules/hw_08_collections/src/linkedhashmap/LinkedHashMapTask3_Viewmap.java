package linkedhashmap;

// Создайте LinkedHashMap, который хранит историю просмотров пользователя (максимум 10 элементов).

// Используй LinkedHashMap<String, String> где ключ — идентификатор страницы, значение — её название
//Если размер мапы 10, а добавляется новый элемент - удаляй первый.
//Выводи историю с помощью entrySet(), порядок будет от самого старого к новому

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTask3_Viewmap {

    public static void main(String[] args) {
        linkedHashMapViewmap();
    }

    public static void linkedHashMapViewmap() {
        LinkedHashMap<String, String> history = new LinkedHashMap<>();

        add(history, "1", "Главная");
        add(history, "2", "Каталог");
        add(history, "3", "Товар 1");
        add(history, "4", "Товар 2");
        add(history, "5", "Корзина");
        add(history, "6", "Оформление");
        add(history, "7", "Профиль");
        add(history, "8", "Настройки");
        add(history, "9", "Избранное");
        add(history, "10", "Помощь");
        add(history, "11", "Контакты");

        print(history);
    }

    public static void add(LinkedHashMap<String, String> map, String key, String value) {
        map.put(key, value);
        if (map.size() > 10) {
            Iterator<Map.Entry<String, String>> iterator =
                    map.entrySet().iterator();

            iterator.next();
            iterator.remove();
        }
    }

    public static void print(LinkedHashMap<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }
    }
}
