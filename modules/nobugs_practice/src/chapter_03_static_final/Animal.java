package chapter_03_static_final;

// Создай базовый класс Animal, содержащий поле с именем.
//Это поле должно быть доступно в классе-наследнике (например, Dog), но не должно
//быть видно извне.
//Пояснение: выбери модификатор доступа, который даёт доступ в иерархии, но
//ограничивает внешний доступ.

public class Animal {
    protected String name_animal;

    public Animal(String someNameAnimal) {
        this.name_animal = someNameAnimal;
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
    public void bark() {
        System.out.println("Имя животного: " + this.name_animal);
    }
}

class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Шарик");
        dog.bark();
    }
}