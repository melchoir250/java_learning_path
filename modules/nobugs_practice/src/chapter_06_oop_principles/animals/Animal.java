package chapter_06_oop_principles.animals;


public abstract class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract String makeSound();

    public void describe() {
        System.out.println(name + " говорит: " + makeSound());
    }
}
