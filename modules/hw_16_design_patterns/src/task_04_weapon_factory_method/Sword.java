package task_04_weapon_factory_method;

public class Sword implements Weapon {
    @Override
    public void attack() {
        System.out.println("Меч: Нанесен удар клинком!");
    }
}
