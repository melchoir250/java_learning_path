package mock_interviews.task17;

public class Main {
    public static void main(String[] args) {
        Course javaCourse = new Course("Java Developer");

        javaCourse.registerStudent("Anna");
        javaCourse.registerStudent("Boris");
        javaCourse.registerStudent("Anna");

        javaCourse.completeCourse("Anna");

        System.out.println("Учатся сейчас: " + javaCourse.getRegisteredCount());
        System.out.println("Завершили: " + javaCourse.getCompletedCount());

        javaCourse.completeCourse("Charlie");
        javaCourse.registerStudent("Anna");
    }
}