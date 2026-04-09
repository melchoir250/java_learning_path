package mock_interviews.task3;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Dragon dragon = new Dragon("Дракон Джони", "коров", "пещера");
        Dog dog = new Dog("Луи", "мясо", "кровати");
        Cat cat = new Cat("Поночка", "влажный корм с кроликом", "подоконике");

        PetService petService = new PetService(List.of(dragon, dog, cat));
        petService.petsEat();
        petService.petsSleep();
    }
}