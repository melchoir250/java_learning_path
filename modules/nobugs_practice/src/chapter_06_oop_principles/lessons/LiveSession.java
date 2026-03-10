package chapter_06_oop_principles.lessons;

class LiveSession extends Lesson {
    private int startTime, endTime;

    public LiveSession(String title, int startTime, int endTime) {
        super(title);
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public int getDuration() {
        return endTime - startTime;
    }
}