package chapter_02_classes_objects;

public class LightBulb {
    boolean isOn;

    LightBulb(boolean someIsOn) {
        this.isOn = someIsOn;
    }

    boolean switchState() {
        if (this.isOn = false) {
            return true;
        }
        return this.isOn = false;
    }

    void printState() {
        System.out.println("Лампочка горит? " + this.isOn);
    }

    public static void main(String[] args) {
        LightBulb light1 = new LightBulb(true);
        light1.printState();
        light1.switchState();
        light1.printState();
    }
}
