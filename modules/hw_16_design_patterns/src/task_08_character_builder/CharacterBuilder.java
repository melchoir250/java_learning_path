package task_08_character_builder;

public class CharacterBuilder {
    private String name = "Безымянный";
    private int health = 100;
    private int attack = 10;
    private int armor = 5;
    private int magic = 0;

    public CharacterBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CharacterBuilder setHealth(int health) {
        this.health = health;
        return this;
    }

    public CharacterBuilder setAttack(int attack) {
        this.attack = attack;
        return this;
    }

    public CharacterBuilder setArmor(int armor) {
        this.armor = armor;
        return this;
    }

    public CharacterBuilder setMagic(int magic) {
        this.magic = magic;
        return this;
    }

    public Character build() {
        return new Character(this);
    }

    protected String getName() {
        return name;
    }

    protected int getHealth() {
        return health;
    }

    protected int getAttack() {
        return attack;
    }

    protected int getArmor() {
        return armor;
    }

    protected int getMagic() {
        return magic;
    }
}
