package mock_interviews.task12;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String nameUniversity;
    private List<Student> students;

    public University(String nameUniversity) {
        this.nameUniversity = nameUniversity;
        this.students = new ArrayList<>();
    }

    public List<Student> getStudents() {
        return students;
    }

    public String getNameUniversity() {
        return nameUniversity;
    }

    public void setNameUniversity(String nameUniversity) {
        this.nameUniversity = nameUniversity;
    }


    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public Student findStudent(int recordId) {
        for (Student item : students) {
            if (item.getNumberRecordBook() == recordId) {
                return item;
            }
        }
        return null;
    }

    public double calculateAverageScore() {
        double sum = 0;
        double count = 0;
        for (Student item : students) {
            sum = sum + item.getNumberGPA();
            count++;
        }
        return sum / count;
    }

    @Override
    public String toString() {
        return getStudents() + getNameUniversity();
    }
}