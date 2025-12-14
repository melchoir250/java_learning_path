package task_pet_management;

public class Dog implements Pet {
    @Override
    public void feed() {
        System.out.println("Ест сухой корм");
    }

    @Override
    public void interact() {
        System.out.println("Гуляет");
    }
}
