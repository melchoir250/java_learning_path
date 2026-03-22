package chapter_06_oop_principles.localization;

public class Main {
    public static void main(String[] args) {
        Localizable lang;
        lang = new Russian();
        System.out.println(lang.translate("Hello"));
        lang = new German();
        System.out.println(lang.translate("Hello"));
        lang = new English();
        System.out.println(lang.translate("Hello"));
    }
}