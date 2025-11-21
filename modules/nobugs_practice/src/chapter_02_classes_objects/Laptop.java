package chapter_02_classes_objects;

public class Laptop {
    String brand;
    int ram;

    Laptop(String setBrand, int setRam) {
        this.brand = setBrand;
        this.ram = setRam;
    }

     String specs() {
        return "Ноутбук: " + this.brand + " с " + this.ram + " ГБ памяти.";
    }

    public static void main(String[] args) {
        Laptop myLaptop = new Laptop("Acer", 48);
        System.out.println(myLaptop.specs());
    }
}
