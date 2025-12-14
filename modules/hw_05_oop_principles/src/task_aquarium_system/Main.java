package task_aquarium_system;

public class Main {
    public static void main(String[] args) {
        Aquarium aquarium = new Aquarium();

        SeaCreature shark = new Shark();
        aquarium.setCreature(shark);
        aquarium.showMovement();

        System.out.println("Создание новой рыбы");

        SeaCreature starfish = new Starfish();
        aquarium.setCreature(starfish);
        aquarium.showMovement();
    }
}
