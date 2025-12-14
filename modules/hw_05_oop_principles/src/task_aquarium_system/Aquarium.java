package task_aquarium_system;

public class Aquarium {
    private SeaCreature creature;

    public void setCreature(SeaCreature sc) {
        this.creature = sc;
        System.out.println("Создаем рыбу");
    }

    public void showMovement() {
        creature.move();
    }
}
