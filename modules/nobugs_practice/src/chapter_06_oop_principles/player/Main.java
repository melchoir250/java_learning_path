package chapter_06_oop_principles.player;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();
        System.out.println(player.getHealth()); // 100

        player.takeDamage(20);
        System.out.println(player.getHealth()); // 80

        player.heal(5);
        System.out.println(player.getHealth()); // 85

        player.takeDamage(100); // Должно установить здоровье в 0
        System.out.println(player.getHealth()); // 0

        player.heal(150); // Должно установить здоровье в 100
        System.out.println(player.getHealth()); // 100

        player.takeDamage(-10); // Не должно изменять здоровье (некорректный урон)
        player.heal(-5); // Не должно изменять здоровье (некорректное лечение)
    }
}
