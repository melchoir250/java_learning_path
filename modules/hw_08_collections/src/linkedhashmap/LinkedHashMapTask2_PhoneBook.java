package linkedhashmap;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class LinkedHashMapTask2_PhoneBook {

    public static void main(String[] args) {
        linkedHashMapPhoneBook();
    }

    public static void linkedHashMapPhoneBook() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();

        map.put("Ivan", "89991234567");
        map.put("Petr", "89991234511");
        map.put("Vasya", "89991234533");
        map.put("Max", "89991234553");
        map.put("Ilya", "89991234512");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя контакта: ");
        String name = scanner.nextLine();

        boolean found = false;

        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().equals(name)) {
                System.out.println("Контакт найден");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Контакт не найден");
        }
    }
}
