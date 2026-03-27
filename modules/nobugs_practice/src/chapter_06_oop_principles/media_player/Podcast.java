package chapter_06_oop_principles.media_player;

public class Podcast implements Playable {
    private final String namePodcast;
    private final String artistPodcast;

    public Podcast(String namePodcast, String artistPodcast) {
        this.namePodcast = namePodcast;
        this.artistPodcast = artistPodcast;
    }

    public String getNamePodcast() {
        return namePodcast;
    }

    public String getArtistPodcast() {
        return artistPodcast;
    }

    @Override
    public void play() {
        System.out.println("Podcast " + namePodcast + " by " + artistPodcast);
    }
}