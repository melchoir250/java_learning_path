package task_pet_management;

public class Cat implements Pet{
    @Override
    public void feed() {
        System.out.println("Ест влажный корм");
    }

    @Override
    public void interact() {
        System.out.println("Играет");
    }
}
