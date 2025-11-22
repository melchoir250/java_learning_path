package chapter_02_classes_objects;

public class TV {
    String brand;
    boolean isOn;

    TV(String someBrand, boolean isOnOff) {
        this.brand = someBrand;
        this.isOn = isOnOff;
    }

    void togglePower() {
        this.isOn = !this.isOn;
    }

    void printState() {
        System.out.println("Телевизор " + this.brand + " сейчас " + this.isOn + ".");
    }

    public static void main(String[] args) {
        TV samsung = new TV("Samsung", true);
        samsung.togglePower();
        samsung.printState();

        TV lg = new TV("LG", false);
        lg.togglePower();
        lg.printState();
    }
}
