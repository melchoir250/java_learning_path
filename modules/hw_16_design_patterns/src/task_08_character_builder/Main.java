package task_08_character_builder;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        Character warrior = game.createWarrior();
        warrior.printStats();

        System.out.println();

        Character mage = game.createMage();
        mage.printStats();

        System.out.println();

        Character paladin = game.createPaladin();
        paladin.printStats();

        System.out.println();

        Character custom = new CharacterBuilder()
                .setName("Ассасин")
                .setHealth(90)
                .setAttack(40)
                .setArmor(8)
                .setMagic(10)
                .build();
        custom.printStats();
    }
}
