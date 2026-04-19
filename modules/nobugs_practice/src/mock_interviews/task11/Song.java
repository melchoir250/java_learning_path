package mock_interviews.task11;

public class Song {
    private final String titleSong;
    private final String artistTitle;
    private int secondsPlaySong;

    public Song(String titleSong, String artistTitle, int secondsPlaySong) {
        this.titleSong = titleSong;
        this.artistTitle = artistTitle;
        this.secondsPlaySong = secondsPlaySong;
    }

    public String getTitleSong() {
        return titleSong;
    }

    public String getArtistTitle() {
        return artistTitle;
    }

    public int getSecondsPlaySong() {
        return secondsPlaySong;
    }

    public void setSecondsPlaySong(int secondsPlaySong) {
        this.secondsPlaySong = secondsPlaySong;
    }

    @Override
    public String toString() {
        return "Песня {" +
                "название='" + getTitleSong() + '\'' +
                ", исполнитель='" + getArtistTitle() + '\'' +
                ", длительность=" + getSecondsPlaySong() + " сек." +
                '}';
    }
}