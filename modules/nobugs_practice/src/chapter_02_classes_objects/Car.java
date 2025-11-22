package chapter_02_classes_objects;

// Создай класс Employee с полями: name, position (String), salary (double).
//Метод describe() печатает: <name> работает как <position> с зарплатой <salary>.

public class Car {
    String name;
    String position;
    double salary;

    Car(String someName, String somePosition, double someSalary) {
        this.name = someName;
        this.position = somePosition;
        this.salary = someSalary;
    }

    void describe() {
        System.out.println(this.name + " работает как " + this.position + " с зарплатой " + this.salary);
    }

    public static void main(String[] args) {
        Car manager = new Car("Альберт", "менеджер", 30000);
        manager.describe();
    }
}
