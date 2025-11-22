package chapter_02_classes_objects;

public class Employee {
    String name;
    String position;
    double salary;

    Employee(String someName, String somePosition, double someSalary) {
        this.name = someName;
        this.position = somePosition;
        this.salary = someSalary;
    }

    void describe() {
        System.out.println(this.name + " работает как " + this.position + " с зарплатой " + this.salary);
    }

    public static void main(String[] args) {
        Employee petr = new Employee("Петр", "инженер", 34.500);
        petr.describe();
    }
}
