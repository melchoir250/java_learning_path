package chapter_06_oop_principles.media_player;

public class Audiobook implements Playable {
    private final String nameAudiobook;
    private final String nameArtist;

    public Audiobook(String nameAudiobook, String nameArtist) {
        this.nameAudiobook = nameAudiobook;
        this.nameArtist = nameArtist;
    }

    public String getNameAudiobook() {
        return nameAudiobook;
    }

    public String getNameArtist() {
        return nameArtist;
    }

    @Override
    public void play() {
        System.out.println("Playing " + nameAudiobook + " " + nameArtist);
    }
}