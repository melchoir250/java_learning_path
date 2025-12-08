package chapter_03_static_final;

//26. Ограниченное количество объектов
//Создай структуру, которая позволяет создать только ограниченное число экземпляров
//(например, не больше 3).
//Если превышен лимит — верни null или сообщение.
//Пояснение: контролируй количество созданных объектов с помощью общего счётчика.

public class LimitedInstance {
    private String name;
    private static int count = 0;

    private LimitedInstance(String someName) {
        this.name = someName;
    }

    public String getName() {
        return this.name;
    }

    public static LimitedInstance create(String name) {
        if (count >= 3) {
            return null;
        }
        count++;
        return new LimitedInstance(name);
    }
}
