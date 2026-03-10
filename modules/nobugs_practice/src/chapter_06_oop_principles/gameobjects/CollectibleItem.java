package chapter_06_oop_principles.gameobjects;

public class CollectibleItem implements GameObject {
    private boolean collected = false;

    @Override
    public void update() {
        if (!collected) {
            System.out.println("Предмет вращается и ждет игрока...");
        }
    }

    @Override
    public void render() {
        if (!collected) {
            System.out.println("Отрисовка предмета на карте.");
        } else {
            System.out.println("Предмет уже подобран.");
        }
    }
}