package task_zoo_animals;

public class Bird implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Птица чирикает");
    }

    @Override
    public void move() {
        System.out.println("Птица летает");
    }
}
