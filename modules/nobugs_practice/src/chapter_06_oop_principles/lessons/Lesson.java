package chapter_06_oop_principles.lessons;

abstract class Lesson {
    private String title;

    public Lesson(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract int getDuration();
}