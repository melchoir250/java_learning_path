package chapter_06_oop_principles.homework_tracking;

public class MathTask implements Task {
    private final String taskId;
    private final String description;
    private final String studentName;
    private final String studentEmail;
    private final String feedback;
    private int score;
    private boolean done = false;

    public MathTask(String feedback, String studentEmail, String studentName, String description, String taskId) {
        this.feedback = feedback;
        this.studentEmail = studentEmail;
        this.studentName = studentName;
        this.description = description;
        this.taskId = taskId;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getDescription() {
        return description;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public String getFeedback() {
        return feedback;
    }

    public int getScore() {
        return score;
    }

    public boolean isDone() {
        return done;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean submit() {
        done = true;
        return done;
    }

    @Override
    public void grade(int grade) {
        if (isDone() == true) {
            setScore(grade);
        } else {
            System.out.println("Task " + taskId + " is not completed, " + studentName);
        }
    }
}