package chapter_03_static_final;

// 4. Инкапсуляция возраста
//Определи класс Person с полем age.
//Поле не должно быть доступно напрямую — возраст должен устанавливаться и
//читаться только через методы.
//Добавь метод увеличения возраста.
//Пояснение: продумай, какие модификаторы доступа подходят для обеспечения
//инкапсуляции.

public class Person {
    private int age;

    public Person(int someAge) {
        this.age = someAge;
    }

    public int getAge() {
        return this.age;
    }

    public int increaseAge(int value) {
        age = age + value;
        return age;
    }

    public static void main(String[] args) {
        Person vasya = new Person(12);
        System.out.println(vasya.getAge());
        System.out.println(vasya.increaseAge(2));
    }
}
