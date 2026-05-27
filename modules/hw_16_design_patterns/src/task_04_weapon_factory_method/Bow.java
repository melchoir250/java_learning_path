package task_04_weapon_factory_method;

public class Bow implements Weapon {
    @Override
    public void attack() {
        System.out.println("Лук: Стрела пущена в цель!");
    }
}
