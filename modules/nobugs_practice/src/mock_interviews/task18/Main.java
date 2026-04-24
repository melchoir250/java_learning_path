package mock_interviews.task18;

public class Main {
    public static void main(String[] args) {
        PhoneBook myBook = new PhoneBook();

        myBook.addContact("Alex", "12345");
        myBook.addContact("Maria", "77777");

        System.out.println("Поиск Alex: " + myBook.findNumberByName("Alex"));

        myBook.addContact("Alex", "99999");
        System.out.println("Новый номер Alex: " + myBook.findNumberByName("Alex"));

        myBook.removeContact("Maria");

        System.out.println("Количество контактов: " + myBook.getContactsCount());
        System.out.println("Проверка существует ли Maria: " + myBook.exists("Maria"));
    }
}