package person;

public class Person {
    private String firstName;
    private String lastName;
    private final String snn;

    Person(String someFirstName, String someLastName, String someSNN) {
        this.firstName = someFirstName;
        this.lastName = someLastName;
        this.snn = someSNN;
    }

    String getFirstName() {
        return this.firstName;
    }

    String getLastName() {
        return this.lastName;
    }

    String getSNN() {
        return this.snn;
    }

    void setFirstName(String newFirstName) {
        this.firstName = newFirstName;
    }

    void setLastName(String newLastName) {
        this.lastName = newLastName;
    }

    void printPersonInfo() {
        System.out.println("Имя: " + getFirstName() + ", Фамилия: " + getLastName() + ", SNN: " + getSNN());
    }
}
