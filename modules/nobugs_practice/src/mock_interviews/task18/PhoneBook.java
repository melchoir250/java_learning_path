package mock_interviews.task18;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private final Map<String, String> contacts;

    public PhoneBook() {
        this.contacts = new HashMap<>();
    }

    public void addContact(String name, String phoneNumber) {
        if (contacts.containsKey(name)) {
            System.out.println("Контакт " + name + " уже существует. Номер обновлен.");
        } else {
            System.out.println("Контакт " + name + " добавлен.");
        }
        contacts.put(name, phoneNumber);
    }

    public void removeContact(String name) {
        if (contacts.remove(name) != null) {
            System.out.println("Контакт " + name + " удален.");
        } else {
            System.out.println("Контакт " + name + " не найден.");
        }
    }

    public String findNumberByName(String name) {
        String number = contacts.get(name);
        if (number != null) {
            return number;
        } else {
            return "Номер не найден";
        }
    }

    public boolean exists(String name) {
        return contacts.containsKey(name);
    }

    public int getContactsCount() {
        return contacts.size();
    }
}