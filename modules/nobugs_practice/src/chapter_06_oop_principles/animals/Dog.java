package chapter_06_oop_principles.animals;


public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public String makeSound() {
        return "Гав-Гав";
    }
}