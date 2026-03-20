package chapter_06_oop_principles.game_bonuses;


public class HealthBoost implements BonusEffect {
    private final int healthBonus;

    public HealthBoost(int healthBonus) {
        this.healthBonus = healthBonus;
    }

    @Override
    public void applyTo(Player player) {
        player.setHealth(player.getHealth() + healthBonus);
    }
}