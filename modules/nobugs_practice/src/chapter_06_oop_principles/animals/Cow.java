package chapter_06_oop_principles.animals;


public class Cow extends Animal {
    public Cow(String name) {
        super(name);
    }

    @Override
    public String makeSound() {
        return "Муу-Муу";
    }


}