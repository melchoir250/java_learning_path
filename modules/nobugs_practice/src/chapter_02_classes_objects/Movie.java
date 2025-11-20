package chapter_02_classes_objects;

public class Movie {
    String name;
    int year;

    Movie(String someName, int someYear) {
        this.name = someName;
        this.year = someYear;
    }

    String getName() {
        return this.name;
    }

    int getYear() {
        return this.year;
    }

    void describe() {
        System.out.println("Фильм " + getName() + ", вышел в " + getYear() + " году");
    }
}
