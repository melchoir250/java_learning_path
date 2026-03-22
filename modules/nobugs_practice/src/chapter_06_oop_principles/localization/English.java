package chapter_06_oop_principles.localization;

public class English implements Localizable {
    @Override
    public String translate(String key) {
        switch (key) {
            case "Hello":
                return "Hello";
            case "Bye":
                return "Bye";
            case "Settings":
                return "Settings";
        }
        return "";
    }
}