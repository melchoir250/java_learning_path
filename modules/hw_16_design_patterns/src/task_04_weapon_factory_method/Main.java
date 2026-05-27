package task_04_weapon_factory_method;

public class Main {
    public static void main(String[] args) {
        WeaponFactory swordFactory = new SwordFactory();
        swordFactory.performWeapon();

        WeaponFactory bowFactory = new BowFactory();
        bowFactory.performWeapon();

        WeaponFactory gunFactory = new GunFactory();
        gunFactory.performWeapon();
    }
}