package task_zoo_animals;

public class Elephant implements Animal{
    @Override
    public void makeSound() {
        System.out.println("Слон трубит");
    }

    @Override
    public void move() {
        System.out.println("Слон ходит");
    }
}