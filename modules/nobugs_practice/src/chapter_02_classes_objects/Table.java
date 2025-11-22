package chapter_02_classes_objects;

public class Table {
    static int width;
    static int height;
    static String material;

    static void describe(String material, int width, int height) {
        System.out.println("Стол из " + material + ", размер " + width + "*" + height);
    }

    public static void main(String[] args) {
        describe("гранит", 200, 180);
        describe("дуба", 100, 80);
    }
}
