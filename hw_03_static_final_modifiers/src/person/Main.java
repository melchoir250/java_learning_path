package person;

public class Main {
    public static void main(String[] args) {
        Person ivan = new Person("Иван", "Данилов", "167-48-3689");
        Person danil = new Person("Данил", "Романов", "147-85-9853");
        ivan.printPersonInfo();
        danil.printPersonInfo();
        ivan.setFirstName("Владимир");
        ivan.printPersonInfo();
    }
}
