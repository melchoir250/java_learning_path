package task_03_student_grades;

import java.util.ArrayList;
import java.util.List;

public class GradeService<T extends Number> {
    private final List<StudentGrade<T>> grades = new ArrayList<>();

    public synchronized void addGrade(StudentGrade<T> grade) {
        if (grade == null) {
            throw new InvalidGradeException("Оценка не может быть Null");
        }

        if (grade.getStudentName() == null) {
            throw new InvalidGradeException("Имя студента не может быть Null");
        }

        if (grade.getGrade() == null) {
            throw new InvalidGradeException("Оценка не может быть Null");
        }

        if (grade.getSubject() == null) {
            throw new InvalidGradeException("Название предмета не может быть Null");
        }

        if (grade.getGrade().doubleValue() < 0) {
            throw new InvalidGradeException("Оценка не может быть отрицательной");
        }
        grades.add(grade);
    }


    public double getAverageBySubject(String subject) {
        if (subject == null) {
            throw new InvalidGradeException("Название предмета не может быть Null");
        }

        double sum = 0;
        int count = 0;

        synchronized (grades) {
            for (StudentGrade<T> StudentGrade : grades) {
                if (subject.equals(StudentGrade.getSubject())) {
                    sum += StudentGrade.getGrade().doubleValue();
                    count++;
                }
            }
        }
        if (count == 0) {
            throw new InvalidGradeException("По предмету нет оценок");
        }
        return sum / count;
    }

    public List<StudentGrade<T>> getAllGrades() {
        synchronized (grades) {
            return new ArrayList<>(grades);
        }
    }
}
