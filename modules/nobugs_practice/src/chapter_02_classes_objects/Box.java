package chapter_02_classes_objects;

public class Box {
    int volume;

    Box(int someVolume) {
        this.volume = someVolume;
    }

    void contains(String item) {
        System.out.println("В коробке лежит " + item);
    }

    public static void main(String[] args) {
        Box box1 = new Box(68);
        box1.contains("Карандаш");
    }
}
