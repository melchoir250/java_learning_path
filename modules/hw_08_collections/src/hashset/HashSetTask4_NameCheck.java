package hashset;


import java.util.HashSet;
import java.util.Scanner;

public class HashSetTask4_NameCheck {

    public static void main(String[] args) {
        hashSetNameCheck();
    }

    public static void hashSetNameCheck() {
        HashSet<String> list_name = new HashSet<>();
        list_name.add("Petr");
        list_name.add("Ivan");
        list_name.add("Vova");
        list_name.add("Max");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String scan = scanner.nextLine();


        if (list_name.contains(scan)) {
            System.out.println("Имя найдено");
        } else {
            System.out.println("Имя не найдено");
        }
    }
}
