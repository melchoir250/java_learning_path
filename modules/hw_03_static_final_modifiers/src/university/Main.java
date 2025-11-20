package university;

public class Main {
    public static void main(String[] args) {
        University student1 = new University(1, "Vladimir");
        University student2 = new University(2, "Artem");
        University student3 = new University(3, "Alex");
        student1.printStudentInfo();
        student2.printStudentInfo();
        student3.printStudentInfo();
        University.changeUniversityName("Institut");
        student1.printStudentInfo();
        student2.printStudentInfo();
        student3.printStudentInfo();
    }
}
