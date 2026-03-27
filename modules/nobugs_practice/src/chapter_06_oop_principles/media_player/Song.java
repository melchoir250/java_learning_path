package chapter_06_oop_principles.media_player;

public class Song implements Playable {
    private final String nameSong;
    private final String nameArtist;

    public Song(String nameSong, String nameArtist) {
        this.nameSong = nameSong;
        this.nameArtist = nameArtist;
    }

    public String getNameSong() {
        return nameSong;
    }

    public String getNameArtist() {
        return nameArtist;
    }

    @Override
    public void play() {
        System.out.println("Playing " + nameSong + " " + nameArtist);
    }
}