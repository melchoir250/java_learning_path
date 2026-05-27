package task_08_character_builder;

public class Game {

    public Character createWarrior() {
        return new CharacterBuilder()
                .setName("Воин")
                .setHealth(200)
                .setAttack(25)
                .setArmor(30)
                .setMagic(0)
                .build();
    }

    public Character createMage() {
        return new CharacterBuilder()
                .setName("Маг")
                .setHealth(80)
                .setAttack(5)
                .setArmor(3)
                .setMagic(50)
                .build();
    }

    public Character createPaladin() {
        return new CharacterBuilder()
                .setName("Паладин")
                .setHealth(150)
                .setAttack(20)
                .setArmor(25)
                .setMagic(15)
                .build();
    }
}
