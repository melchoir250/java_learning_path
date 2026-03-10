package chapter_06_oop_principles.gameobjects;

class Enemy implements GameObject {
    private int x = 0;


    @Override
    public void update() {
        x++;
    }

    @Override
    public void render() {
        System.out.println("Отрисовка врага на позиции: " + x);
    }
}