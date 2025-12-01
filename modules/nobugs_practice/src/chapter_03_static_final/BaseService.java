package chapter_03_static_final;

// Реализуй класс BaseService, в котором есть метод shutdown() — его можно
//вызывать в наследниках, но переопределять нельзя.
//Пояснение: выбери нужный модификатор, чтобы зафиксировать реализацию метода.

public class BaseService {
    protected final void shutdown() {
        System.out.println();
    }
}
