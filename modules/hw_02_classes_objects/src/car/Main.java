package car;

public class Main {
    public static void main(String[] args) {
        Car toyota  = new Car("Toyota", 13);
        toyota.print();
        toyota.setBrand("Lexus");
        toyota.setYear(3);
        toyota.print();

        Car vw = new Car("Audi", 7);
        vw.setBrand("Porsche");
        vw.setYear(2);
        vw.print();
    }
}
