package mock_interviews.task12;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Petr", 1, 3.5);
        Student student2 = new Student("Ivan", 2, 4.6);
        Student student3 = new Student("Mick", 3, 4.9);
        Student student4 = new Student("Alex", 4, 3.1);

        List<Student> students = List.of(student1, student2, student3, student4);

        University university = new University("KQW");

        for (Student item : students) {
            university.addStudent(item);
        }

        System.out.println(university.getStudents());
        System.out.println("Средняя оценка: " + university.calculateAverageScore());
    }
}