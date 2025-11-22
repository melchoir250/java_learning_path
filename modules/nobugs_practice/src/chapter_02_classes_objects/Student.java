package chapter_02_classes_objects;

// 15. Класс Student
//Определи класс Student с полями name (String) и gpa (double).
//Метод isHonorsStudent() возвращает true, если gpa > 4.5.
//Метод printStatus() выводит, в зависимости от результата, отличник ли студент.

public class Student {
    String name;
    double gpa;

    Student(String someName, double someGpa) {
        this.name = someName;
        this.gpa = someGpa;
    }

    String isHonorStudent() {
        String description = "не отличник";
        if (this.gpa > 4.5) {
            description = "отличник";
        }
        return description;
    }

    String printStatus() {
        return this.name + isHonorStudent();
    }

    public static void main(String[] args) {
        Student petr = new Student("Петр ", 21.5);
        Student vasya = new Student("Василий ", 4.4);
        System.out.println(petr.printStatus());
        System.out.println(vasya.printStatus());
    }

}
