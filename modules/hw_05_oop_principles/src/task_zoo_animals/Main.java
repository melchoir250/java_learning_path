package task_zoo_animals;

public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();

        Animal elephant = new Elephant();
        zoo.setAnimal(elephant);
        zoo.showAnimalBehavior();

        System.out.println("Меняем животное");

        Animal bird = new Bird();
        zoo.setAnimal(bird);
        zoo.showAnimalBehavior();
    }
}