package chapter_03_static_final;

// 13. Приватный конструктор и фабричный метод
//Реализуй класс, который не позволяет создавать объекты напрямую через new.
//Вместо этого, должен быть специальный метод create() или getInstance(), через
//который объект создаётся и возвращается.
//Пояснение: примени паттерн фабрики или одиночки с приватным конструктором.

public class PrivateFabrivMethod {
    private String method_fabr;

    private PrivateFabrivMethod(String someMethodFabr) {
        this.method_fabr = someMethodFabr;
    }

    public static PrivateFabrivMethod create(String value) {
        PrivateFabrivMethod method1 = new PrivateFabrivMethod(value);
        System.out.println(method1.method_fabr);
        return method1;
    }
}
