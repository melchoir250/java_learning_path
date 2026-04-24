package mock_interviews.task20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GradeBook {
    private final Map<String, List<Integer>> journal;

    public GradeBook() {
        this.journal = new HashMap<>();
    }

    public void addGrade(String studentName, int grade) {
        journal.computeIfAbsent(studentName, k -> new ArrayList<>()).add(grade);
        System.out.println("Добавлена оценка " + grade + " студенту " + studentName);
    }

    public List<Integer> getGrades(String studentName) {
        return journal.getOrDefault(studentName, new ArrayList<>());
    }

    public double getAverageGrade(String studentName) {
        List<Integer> grades = journal.get(studentName);
        if (grades == null || grades.isEmpty()) {
            return 0.0;
        }
        double sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    public boolean hasStudent(String studentName) {
        return journal.containsKey(studentName);
    }

    public int getStudentsCount() {
        return journal.size();
    }
}