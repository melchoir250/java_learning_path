package chapter_06_oop_principles.game_bonuses;


public class DamageMultiplier implements BonusEffect {
    private final int damageBonus;

    public DamageMultiplier(int damageBonus) {
        this.damageBonus = damageBonus;
    }

    @Override
    public void applyTo(Player player) {
        double damageBonusEffect = (1 + damageBonus / 100.0);
        player.setDamage((int) (player.getDamage() * damageBonusEffect));
    }
}