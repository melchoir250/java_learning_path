package task_04_weapon_factory_method;

public class Gun implements Weapon {
    @Override
    public void attack() {
        System.out.println("Пистолет: Выстрел пулей!");
    }
}
