package chapter_06_oop_principles.gameobjects;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<GameObject> objects = new ArrayList<>();

        objects.add(new Player());
        objects.add(new Enemy());
        objects.add(new CollectibleItem());

        for (GameObject obj : objects) {
            obj.update();
            obj.render();
        }
    }
}