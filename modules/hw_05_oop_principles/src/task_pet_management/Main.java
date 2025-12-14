package task_pet_management;

public class Main {
    public static void main(String[] args) {
        PetManager pet_manager = new PetManager();

        Pet dog = new Dog();
        pet_manager.setPet(dog);
        pet_manager.handlePet();

        System.out.println("Меняется животное");

        Cat cat = new Cat();
        pet_manager.setPet(cat);
        pet_manager.handlePet();
    }
}
