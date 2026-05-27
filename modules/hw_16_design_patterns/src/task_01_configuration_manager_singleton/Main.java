package task_01_configuration_manager_singleton;

public class Main {
    public static void main(String[] args) {
        ConfigurationManager config1 = ConfigurationManager.getInstance();
        System.out.println("URL базы данных: " + config1.getDbUrl());

        ConfigurationManager config2 = ConfigurationManager.getInstance();
        System.out.println("Уровень логирования: " + config2.getLogLevel());

        if (config1 == config2) {
            System.out.println("Оба объекта абсолютно одинаковы");
        } else {
            System.out.println("Оба объекта не одинаковы");
        }
    }
}
