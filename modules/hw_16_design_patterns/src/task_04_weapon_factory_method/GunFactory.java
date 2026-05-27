package task_04_weapon_factory_method;

public class GunFactory extends WeaponFactory {
    @Override
    public Weapon createWeapon() {
        return new Gun();
    }
}
