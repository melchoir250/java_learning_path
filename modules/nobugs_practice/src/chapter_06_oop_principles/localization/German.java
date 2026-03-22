package chapter_06_oop_principles.localization;

public class German implements Localizable {
    @Override
    public String translate(String key) {
        switch (key) {
            case "Hello":
                return "Hallo";
            case "Bye":
                return "Tschüss";
            case "Settings":
                return "Einstellungen";
        }
        return "";
    }
}