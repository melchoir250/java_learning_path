package chapter_02_classes_objects;

public class Person {
    String firstName;
    String lastName;

    Person(String someFirstName, String someLastName) {
        this.firstName = someFirstName;
        this.lastName = someLastName;
    }

    String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public static void main(String[] args) {
        Person ivan = new Person("Иван", "Петров");
        System.out.println(ivan.getFullName());
    }
}
