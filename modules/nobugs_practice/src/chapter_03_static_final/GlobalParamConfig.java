package chapter_03_static_final;

//  Глобальные параметры конфигурации
//Нужно реализовать компонент, где хранятся параметры вроде "timeout" "apiUrl" и т. д.
//Эти параметры могут меняться во время выполнения, но доступны глобально — для всех частей программы.
//Пояснение: используй статические поля или методы с контролем доступа.

public class GlobalParamConfig {
    public static String apiUrl;
    public static int timeout;
}
