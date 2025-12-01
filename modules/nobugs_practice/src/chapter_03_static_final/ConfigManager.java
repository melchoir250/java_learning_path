package chapter_03_static_final;

// Создание объекта через фабричный метод
//Создай класс, у которого нельзя вызвать new извне.
//Создание объекта должно происходить только через специальный метод create(),
//который возвращает готовый экземпляр.
//Пояснение: реализуй паттерн, при котором конструктор недоступен внешнему коду.

public class ConfigManager {
    private String new_method;

    private ConfigManager(String someNewMethod) {
        this.new_method = someNewMethod;
    }

    public static ConfigManager create(String value) {
        ConfigManager config1 = new ConfigManager(value);
        System.out.println(config1.new_method);
        return config1;
    }
}
