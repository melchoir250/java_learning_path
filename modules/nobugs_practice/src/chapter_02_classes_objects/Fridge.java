package chapter_02_classes_objects;

public class Fridge {
    int temperature;

    Fridge(int someTemperature) {
        this.temperature = someTemperature;
    }

    String getStatus() {
        return "Холодильник охлаждает при " + this.temperature + " градусах.";
    }

    public static void main(String[] args) {
        Fridge fridge_lg = new Fridge(12);
        System.out.println(fridge_lg.getStatus());
    }
}
