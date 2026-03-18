package task_03_student_grades;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GradeServiceTest {

    private GradeService<Integer> service = new GradeService<>();

    @Test
    public void shouldAddValidGrate() {
        StudentGrade<Integer> grade = new StudentGrade<>("Иван", "Математика", 5);
        service.addGrade(grade);
        assertEquals(1, service.getAllGrades().size());
    }

    @Test
    public void shouldAddValidGrateNegative() {
        StudentGrade<Integer> grade = new StudentGrade<>("Иван", "Математика", -1);
        InvalidGradeException exception = assertThrows(InvalidGradeException.class, () -> service.addGrade(grade));
        assertEquals("Оценка не может быть отрицательной", exception.getMessage());
    }

    @Test
    public void shouldAddValidGrateNull() {
        InvalidGradeException exception = assertThrows(InvalidGradeException.class, () -> service.addGrade(null));
        assertEquals("Оценка не может быть Null", exception.getMessage());
    }

    @Test
    public void shouldCalculateAverageGrateBySubject() {
        service.addGrade(new StudentGrade<>("Иван", "Математика", 5));
        service.addGrade(new StudentGrade<>("Петя", "Математика", 3));
        service.addGrade(new StudentGrade<>("Даша", "Информатика", 4));

        double average = service.getAverageBySubject("Математика");
        assertEquals(4.0, average);
    }

    @Test
    public void shouldWorkDoubleGrate() {
        GradeService<Double> doubleGradeService = new GradeService<>();
        doubleGradeService.addGrade(new StudentGrade<Double>("Иван", "Математика", 4.5));
        doubleGradeService.addGrade(new StudentGrade<Double>("Иван", "Математика", 3.5));

        double average = doubleGradeService.getAverageBySubject("Математика");
        assertEquals(4.0, average);
    }
}