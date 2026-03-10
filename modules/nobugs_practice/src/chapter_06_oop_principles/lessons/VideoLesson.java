package chapter_06_oop_principles.lessons;

class VideoLesson extends Lesson {
    private int videoLength;

    public VideoLesson(String title, int videoLength) {
        super(title);
        this.videoLength = videoLength;
    }

    @Override
    public int getDuration() {
        return videoLength;
    }
}