package task_farm_animal;

public class Cow implements FarmAnimal {
    @Override
    public void feed() {
        System.out.println("Ест траву");
    }

    @Override
    public void care() {
        System.out.println("Выпас");
    }

    @Override
    public void produce() {
        System.out.println("Даёт молоко");
    }
}
