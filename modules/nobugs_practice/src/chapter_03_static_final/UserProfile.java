package chapter_03_static_final;

// Создай класс UserProfile, в котором имя доступно публично, а паспортный номер
//скрыт от других классов.
//Паспорт можно установить один раз при создании и далее только прочитать изнутри.
//Пояснение: поработай с модификаторами доступа, геттерами и финальными полями.

public class UserProfile {
    public String name;
    private final String PASSPORT;

    UserProfile(String someName) {
        this.name = someName;
        PASSPORT = "0234-435728";
    }

    String getName() {
        return this.name;
    }

    void setName(String newName) {
        this.name = newName;
    }

    void print() {
        System.out.println(getName() + PASSPORT);
    }

    public static void main(String[] args) {
        UserProfile vasiliy = new UserProfile("Василий: ");
        vasiliy.print();
    }
}
