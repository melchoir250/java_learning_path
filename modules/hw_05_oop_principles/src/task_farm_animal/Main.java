package task_farm_animal;

public class Main {
    public static void main(String[] args) {
        Farm farm_animal = new Farm();

        System.out.println("Корова");

        FarmAnimal cow = new Cow();
        farm_animal.setAnimal(cow);
        farm_animal.serviceAnimal();

        System.out.println("Курица");

        FarmAnimal chicken = new Chicken();
        farm_animal.setAnimal(chicken);
        farm_animal.serviceAnimal();
    }
}
