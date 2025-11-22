package chapter_02_classes_objects;

public class Printer {
    static void print(String text) {
        System.out.println("Печать: " + text);
    }

    public static void main(String[] args) {
        print("Петушок золотой гребешок");
    }
}
