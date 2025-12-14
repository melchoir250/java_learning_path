package task_farm_animal;

public class Farm {
    private FarmAnimal animal;

    public void setAnimal(FarmAnimal animal_farm) {
        this.animal = animal_farm;
    }

    public void serviceAnimal() {
        animal.feed();
        animal.care();
        animal.produce();
    }
}
