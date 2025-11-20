package chapter_02_classes_objects;

public class User {
    String username;
    int age;

    User(String someUsername, int someAge) {
        this.username = someUsername;
        this.age = someAge;
    }

    void introduce() {
        System.out.println("Привет, меня зовут " + this.username + ", мне " + this.age + " лет");
    }
}
