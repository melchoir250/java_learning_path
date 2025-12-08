package chapter_03_static_final;

//27. Глобальный режим отладки
//Создай логическую переменную debugMode, отражающую, находится ли программа в
//режиме отладки.
//Она должна быть доступна в любом месте и изменяема через специальные методы.
//Пояснение: реализуй статическое поле с контролем доступа.

public class DebugConfig {
    private static boolean debugMode;

    public static boolean getDebugMode() {
        return debugMode;
    }

    public static void setDebugMode(boolean newBugMode) {
        debugMode = newBugMode;
    }
}
