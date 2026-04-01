package chapter_06_oop_principles.homework_tracking;

public class Teacher {
    public final String name;

    public Teacher(String name) {
        this.name = name;
    }

    public void evaluate(Task task, int score) {
        task.grade(score);
    }
}