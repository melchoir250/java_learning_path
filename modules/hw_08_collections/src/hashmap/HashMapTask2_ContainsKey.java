package hashmap;


import java.util.HashMap;
import java.util.Scanner;

public class HashMapTask2_ContainsKey {

    public static void main(String[] args) {
        hashMapTaskContainsKey();
    }

    public static void hashMapTaskContainsKey() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("a", 1);
        hashMap.put("b", 2);
        hashMap.put("c", 3);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите переменную: ");
        String word = scanner.nextLine();


        if (hashMap.containsKey(word)) {
            System.out.println("Найдено");
        } else {
            System.out.println("Не найдено");
        }
    }
}
