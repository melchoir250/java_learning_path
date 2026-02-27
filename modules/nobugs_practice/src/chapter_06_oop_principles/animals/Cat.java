package chapter_06_oop_principles.animals;


public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public String makeSound() {
        return "Мяу-Мяу";
    }
}