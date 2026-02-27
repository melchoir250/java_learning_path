package chapter_06_oop_principles.player;


public class Player {

    private int health;
    private static final int MAX_HEALTH = 100;
    private static final int MIN_HEALTH = 0;

    public Player() {
        this.health = MAX_HEALTH;
    }

    public Player(int initialHealth) {
        if (initialHealth < MIN_HEALTH) {
            this.health = MIN_HEALTH;
        } else if (initialHealth > MAX_HEALTH) {
            this.health = MAX_HEALTH;
        } else {
            this.health = initialHealth;
        }
    }

    public void takeDamage(int damage) {
        if (damage <= 0) {
            System.out.println("Урон должен быть положительным");
            return;
        }

        health -= damage;

        if (health < MIN_HEALTH) {
            health = MIN_HEALTH;
        }
    }

    public void heal(int amount) {
        if (amount <= 0) {
            System.out.println("Лечение должно быть положительным");
            return;
        }

        health += amount;

        if (health > MAX_HEALTH) {
            health = MAX_HEALTH;
        }
    }

    public int getHealth() {
        return health;
    }
}