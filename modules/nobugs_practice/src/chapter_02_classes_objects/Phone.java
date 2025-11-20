package chapter_02_classes_objects;

public class Phone {
    String model;
    int batteryLevel;

    Phone(String someModel, int someBatteryLevel) {
        this.model = someModel;
        this.batteryLevel = someBatteryLevel;
    }

    void call(String number) {
        System.out.println("Звоню на номер " + number + " с телефона " + this.model);
    }
}
