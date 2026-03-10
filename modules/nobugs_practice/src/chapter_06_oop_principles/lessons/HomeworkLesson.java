package chapter_06_oop_principles.lessons;

class HomeworkLesson extends Lesson {

    private int homeworkDuration;

    public HomeworkLesson(String title, int homeworkDuration) {
        super(title);
        this.homeworkDuration = homeworkDuration;
    }

    @Override
    public int getDuration() {
        return homeworkDuration;
    }
}