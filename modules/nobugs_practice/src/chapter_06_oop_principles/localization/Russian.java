package chapter_06_oop_principles.localization;

public class Russian implements Localizable {
    @Override
    public String translate(String key) {
        switch (key) {
            case "Hello":
                return "Привет";
            case "Bye":
                return "Пока";
            case "Settings":
                return "Настройки";
        }
        return "";
    }
}