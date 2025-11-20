package person;

public class Main {
    public static void main(String[] args) {
        Person ivan = new Person("Иван", "Бунин", "635-74-8543");
        Person petr = new Person("Петр", "Аметисов", "645-62-3563");
        ivan.printPersonInfo();
        petr.printPersonInfo();
        ivan.setFirstName("Ванечка");
        ivan.printPersonInfo();
    }
}
