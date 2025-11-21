package chapter_02_classes_objects;

public class Cat {
    String name;
    int age;

    Cat(String someName, int someAge) {
        this.name = someName;
        this.age = someAge;
    }

    String meow() {
        return "Кошка " + this.name + " мяукает.";
    }

    String sleep() {
        return "Кошка " + this.name + " спит.";
    }

    public static void main(String[] args) {
        Cat ponya = new Cat("Поня", 5);
        System.out.println(ponya.meow());
        System.out.println(ponya.sleep());
    }
}
