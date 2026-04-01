package chapter_06_oop_principles.homework_tracking;

public class JavaTask implements Task {
    private final String taskId;
    private final String description;
    private final String studentName;
    private int score;
    private boolean done = false;

    public JavaTask(String taskId, String description, String studentName) {
        this.taskId = taskId;
        this.description = description;
        this.studentName = studentName;
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

    public int getScore() {
        return score;
    }

    public boolean isDone() {
        return done;
    }

    private void setScore(int score) {
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