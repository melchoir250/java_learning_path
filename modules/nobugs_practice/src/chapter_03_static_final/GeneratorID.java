package chapter_03_static_final;

// Реализуй класс, который предоставляет уникальные числовые идентификаторы.
//Объекты этого класса не создаются — он предоставляет метод, возвращающий
//следующее доступное число.
//Пояснение: нужно организовать статическое поведение и скрыть возможность
//создания экземпляров.

public class GeneratorID {
    private static int uniq_identificated;

    private GeneratorID() {
    }

    public static int generateUniqIdentificated() {
        uniq_identificated++;
        return uniq_identificated;
    }
}
