package chapter_06_oop_principles.game_bonuses;


import java.util.List;

public class Player {
    private final String namePlayer;
    private int health;
    private int speed;
    private int damage;

    public Player(String namePlayer, int health, int speed, int damage) {
        this.namePlayer = namePlayer;
        this.health = health;
        this.speed = speed;
        this.damage = damage;
    }

    public String getNamePlayer() {
        return namePlayer;
    }

    public int getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }

    public int getDamage() {
        return damage;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void applyBonus(List<BonusEffect> bonuses) {
        for (BonusEffect bonus : bonuses) {
            bonus.applyTo(this);
        }
    }
}