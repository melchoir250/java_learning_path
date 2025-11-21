package chapter_02_classes_objects;

public class Dog {
    String name;
    String breed;

    Dog(String someName, String someBreed) {
        this.name = someName;
        this.breed = someBreed;
    }

    String bark() {
        return ("Собака " + this.name + " породы " + this.breed + " лает: Гав-гав!.");
    }

    public static void main(String[] args) {
        Dog lui = new Dog("Луи", "Кавалер Кинг Чарльз");
        System.out.println(lui.bark());
    }
}
