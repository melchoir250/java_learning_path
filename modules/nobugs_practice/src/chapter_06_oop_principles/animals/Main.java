package chapter_06_oop_principles.animals;

public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog("Луи");
        dog.describe();

        Animal cat = new Cat("Поня");
        cat.describe();

        Animal cow = new Cow("Мурка");
        cow.describe();
    }
}
