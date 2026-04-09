package mock_interviews.task3;

import java.util.ArrayList;
import java.util.List;

public class PetService {
    private List<Pet> pet = new ArrayList<>();

    public PetService(List<Pet> pet) {
        this.pet = pet;
    }

    public void addPet(Pet p) {
        pet.add(p);
    }

    public void petsEat() {
        for (Pet item : pet) {
            System.out.println(item.eat());
        }
    }

    public void petsSleep() {
        for (Pet item : pet) {
            System.out.println(item.sleep());
        }
    }
}