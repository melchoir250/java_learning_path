package mock_interviews.task17;

import java.util.HashSet;
import java.util.Set;

public class Course {
    private final String title;
    private final Set<String> registeredStudents;
    private final Set<String> completedStudents;

    public Course(String title) {
        this.title = title;
        this.registeredStudents = new HashSet<>();
        this.completedStudents = new HashSet<>();
    }

    public void registerStudent(String studentName) {
        if (completedStudents.contains(studentName)) {
            System.out.println(studentName + " уже завершил этот курс.");
            return;
        }
        if (registeredStudents.add(studentName)) {
            System.out.println(studentName + " зарегистрирован на курс");
        } else {
            System.out.println(studentName + " уже зарегистрирован");
        }
    }

    public void completeCourse(String studentName) {
        if (!registeredStudents.contains(studentName)) {
            System.out.println("Нельзя завершить курс без регистрации. (" + studentName + ")");
            return;
        }
        completedStudents.add(studentName);
        registeredStudents.remove(studentName);
        System.out.println(studentName + " успешно завершил курс!");
    }

    public boolean isRegistered(String studentName) {
        return registeredStudents.contains(studentName);
    }

    public boolean hasCompleted(String studentName) {
        return completedStudents.contains(studentName);
    }

    public int getRegisteredCount() {
        return registeredStudents.size();
    }

    public int getCompletedCount() {
        return completedStudents.size();
    }
}