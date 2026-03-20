package chapter_06_oop_principles.game_bonuses;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        Player player = new Player("Ogr", 100, 5, 30);
        System.out.printf(
                """
                        [PLAYER]
                        Name=%s | HP=%d | SPD=%d | DMG=%d
                        %n""", player.getNamePlayer(),
        player.getHealth(),
        player.getSpeed(),
        player.getDamage()
);

        List<BonusEffect> bonuses = List.of(
                new HealthBoost(33),
                new SpeedBoost(4),
                new DamageMultiplier(33)
        );
        player.applyBonus(bonuses);

        System.out.printf(
                """
                        [PLAYER Upd Bonus]
                        Name=%s | HP=%d | SPD=%d | DMG=%d
                        %n""", player.getNamePlayer(),
        player.getHealth(),
        player.getSpeed(),
        player.getDamage()
);
    }
}