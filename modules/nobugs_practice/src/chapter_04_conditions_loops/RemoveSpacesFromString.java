package chapter_04_conditions_loops;

import java.util.Scanner;

public class RemoveSpacesFromString {
    public static void main(String[] args) {
        removeSpaceFromString();
    }

    public static void removeSpaceFromString() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String scanString = scanner.nextLine();

        String result = scanString.replace(" ", "");
        System.out.println(result);
    }
}
