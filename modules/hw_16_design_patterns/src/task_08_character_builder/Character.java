package task_08_character_builder;

public class Character {
    private final String name;
    private final int health;
    private final int attack;
    private final int armor;
    private final int magic;

    protected Character(CharacterBuilder builder) {
        this.name = builder.getName();
        this.health = builder.getHealth();
        this.attack = builder.getAttack();
        this.armor = builder.getArmor();
        this.magic = builder.getMagic();
    }

    public void printStats() {
        System.out.println("--- ПЕРСОНАЖ ---");
        System.out.println("Имя: " + name);
        System.out.println("Здоровье: " + health);
        System.out.println("Урон: " + attack);
        System.out.println("Броня: " + armor);
        System.out.println("Магия: " + magic);
    }
}
