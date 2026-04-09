package mock_interviews.task3;

public abstract class PetAbstract implements Pet {
    protected String namePet;
    protected String eatPet;
    protected String sleepPet;

    public PetAbstract(String namePet, String eatPet, String sleepPet) {
        this.namePet = namePet;
        this.eatPet = eatPet;
        this.sleepPet = sleepPet;
    }

    public String getNamePet() {
        return namePet;
    }

    public String getEatPet() {
        return eatPet;
    }

    public String getSleepPet() {
        return sleepPet;
    }

    public void setNamePet(String namePet) {
        this.namePet = namePet;
    }

    public void setEatPet(String eatPet) {
        this.eatPet = eatPet;
    }

    public void setSleepPet(String sleepPet) {
        this.sleepPet = sleepPet;
    }
}