package task_12_smart_home_facade;

public class Main {
    public static void main(String[] args) {
        SmartHomeFacade smartHome = new SmartHomeFacade();

        System.out.println("Включаем все системы:");
        smartHome.turnEverythingOn();

        System.out.println();
        System.out.println("Выключаем все системы:");
        smartHome.turnEverythingOff();
    }
}
