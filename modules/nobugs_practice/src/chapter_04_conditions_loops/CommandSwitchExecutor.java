package chapter_04_conditions_loops;

import java.util.Scanner;

public class CommandSwitchExecutor {
    public static void main(String[] args) {
        commandSwitch();
    }

    public static void commandSwitch() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите команду print/save/exit: ");
        String command = scanner.nextLine();
        switch (command) {
            case "print":
                System.out.println("Печать данных");
                break;

            case "save":
                System.out.println("Сохранение данных");
                break;

            case "exit":
                System.out.println("Выход из программы");
                break;

            default:
                System.out.println("Неизвестная команда");
        }
    }
}
