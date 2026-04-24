package mock_interviews.task20;

public class Main {
    public static void main(String[] args) {
        GradeBook book = new GradeBook();

        book.addGrade("Anna", 5);
        book.addGrade("Anna", 4);
        book.addGrade("Boris", 3);

        System.out.println("Anna: " + book.getGrades("Anna"));
        System.out.println("Boris: " + book.getGrades("Boris"));

        System.out.printf("Anna: ", book.getAverageGrade("Anna"));
        System.out.printf("Boris: ", book.getAverageGrade("Boris"));

        System.out.println("Всего студентов в журнале: " + book.getStudentsCount());
    }
}