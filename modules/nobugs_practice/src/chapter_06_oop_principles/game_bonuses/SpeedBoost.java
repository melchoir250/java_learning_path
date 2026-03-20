package chapter_06_oop_principles.game_bonuses;


public class SpeedBoost implements BonusEffect {
    private final int speedBonus;

    public SpeedBoost(int speedBonus) {
        this.speedBonus = speedBonus;
    }

    @Override
    public void applyTo(Player player) {
        player.setSpeed(player.getSpeed() + speedBonus);
    }
}