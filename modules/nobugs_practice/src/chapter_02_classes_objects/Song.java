package chapter_02_classes_objects;

public class Song {
    String title;
    int duration;

    Song(String someTitle, int someDuration) {
        this.title = someTitle;
        this.duration = someDuration;
    }

    void play() {
        System.out.println("Сейчас играет: " + this.title + " (" + this.duration + " секунд).");
    }

    public static void main(String[] args) {
        Song song1 = new Song("Lavine", 18);
        song1.play();
    }
}
