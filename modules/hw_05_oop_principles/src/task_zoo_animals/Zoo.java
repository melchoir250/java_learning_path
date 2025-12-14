package task_zoo_animals;

public class Zoo {
    private Animal current_animal;

    public void setAnimal(Animal animal) {
        this.current_animal = animal;
        System.out.println("Создаем животное");
    }

    public void showAnimalBehavior() {
        if (current_animal != null) {
            current_animal.makeSound();
            current_animal.move();
        }
    }
}
