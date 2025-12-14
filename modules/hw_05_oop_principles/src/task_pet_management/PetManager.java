package task_pet_management;

public class PetManager {
    private Pet pet;

    public void setPet(Pet pet) {
        this.pet = pet;
        System.out.println("Создается животное");
    }

    public void handlePet() {
        if (pet != null) {
            pet.feed();
            pet.interact();
        }
    }
}
