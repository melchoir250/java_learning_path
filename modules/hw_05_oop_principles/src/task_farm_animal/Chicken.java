package task_farm_animal;

public class Chicken implements FarmAnimal{
    @Override
    public void feed() {
        System.out.println("Ест зерно");
    }

    @Override
    public void care() {
        System.out.println("Нуждается в кормушке");
    }

    @Override
    public void produce() {
        System.out.println("Несёт яйца");
    }
}
