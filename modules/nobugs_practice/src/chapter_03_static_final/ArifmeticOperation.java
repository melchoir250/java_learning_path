package chapter_03_static_final;

// 10. Класс без наследников
//Разработай класс с полезными методами (например, арифметические операции), от
//которого нельзя унаследоваться.
//Пояснение: определи, как запретить наследование, и продумай, какие методы можно
//сделать статическими.

public final class ArifmeticOperation {
    private int a;
    private int b;

    private ArifmeticOperation(int someA, int someB) {
        this.a = someA;
        this.b = someB;
    }

    public static int add(int a, int b) {
        return a + b;
    }
}
