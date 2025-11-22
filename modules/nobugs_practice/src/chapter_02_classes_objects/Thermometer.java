package chapter_02_classes_objects;

public class Thermometer {
    double currentTemp;

    Thermometer(double someCurrentTemp) {
        this.currentTemp = someCurrentTemp;
    }

    void display() {
        System.out.println("Температура: " + this.currentTemp);
    }

    boolean isFever() {
        return this.currentTemp > 37.5;
    }

    public static void main(String[] args) {
        Thermometer therm1 = new Thermometer(12);
        therm1.display();
        System.out.println(therm1.isFever());
    }
}
