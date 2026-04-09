package mock_interviews.task3;

public class Dragon extends PetAbstract {
    public Dragon(String namePet, String eatPet, String sleepPet) {
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