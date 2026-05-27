package task_04_weapon_factory_method;

public abstract class WeaponFactory {
    public abstract Weapon createWeapon();

    public void performWeapon() {
        Weapon weapon = createWeapon();
        weapon.attack();
    }
}
