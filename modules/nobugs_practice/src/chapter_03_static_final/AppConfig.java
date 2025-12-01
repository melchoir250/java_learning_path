package chapter_03_static_final;

//Нужно реализовать параметр конфигурации, например "development" или
//"production"
//, который можно прочитать и изменить из любого класса.
//Он общий для всей программы, не зависит от объектов.
//Пояснение: реши, как объявить и организовать такие общие переменн

public class AppConfig {
    static String dev = "development";

    public static void configPrint() {
        System.out.println(dev);
    }

    public static void setAppConfig(String new_dev) {
        dev = new_dev;
    }

    public static void main(String[] args) {
        configPrint();
        setAppConfig("production");
        configPrint();
        setAppConfig("dev");
        configPrint();
    }

}
