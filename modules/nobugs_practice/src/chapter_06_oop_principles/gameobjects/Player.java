package chapter_06_oop_principles.gameobjects;

public class Player implements GameObject {
    private int health = 100;

    @Override
    public void update() {
        System.out.println("Игрок проверяет нажатия клавиш...");
    }

    @Override
    public void render() {
        System.out.println("Отрисовка игрока. Здоровье: " + health);
    }
}