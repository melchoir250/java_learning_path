public class Student {
    // поля
    int age;
    String name;

    // конструктор
    Student(int someAge, String someName) {
        this.age = someAge;
        this.name = someName;
    }

    //геттер для возраста
    int getAge() {

        return this.age;
    }

    //геттер для имени
    String getName() {

        return this.name;
    }

    //сеттер для возаста
    void setAge(int newAge) {

        this.age = newAge;
    }

    //сеттер для имени
    void setName(String newName) {

        this.name = newName;
    }

    void print() {

        System.out.println("Возраст " + this.age + ", имя " + this.name);
    }
}
