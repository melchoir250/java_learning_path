package mock_interviews.task3;

public class Dog extends PetAbstract {
    public Dog(String namePet, String eatPet, String sleepPet) {
        super(namePet, eatPet, sleepPet);
    }

    @Override
    public String eat() {
        return namePet + " ест " + eatPet;
    }

    @Override
    public String sleep() {
        return namePet + " спит на " + sleepPet;
    }
}