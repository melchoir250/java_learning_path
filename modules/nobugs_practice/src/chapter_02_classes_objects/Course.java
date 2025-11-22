package chapter_02_classes_objects;

public class Course {
    String name;
    int studentsEnrolled;

    Course(String someName, int someStudentsEnrolled) {
        this.name = someName;
        this.studentsEnrolled = someStudentsEnrolled;
    }

    int addStudent() {
        return this.studentsEnrolled += 1;
    }

    void printInfo() {
        System.out.println("Название курса: " + this.name + " , количество студентов: " + this.studentsEnrolled);
    }

    public static void main(String[] args) {
        Course selling = new Course("Продажи", 33);
        selling.printInfo();
        selling.addStudent();
        selling.addStudent();
        selling.addStudent();
        selling.printInfo();
    }
}
