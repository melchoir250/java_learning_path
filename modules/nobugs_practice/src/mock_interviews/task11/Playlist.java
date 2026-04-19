package mock_interviews.task11;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private List<Song> songsPlaylist;

    public Playlist() {
        this.songsPlaylist = new ArrayList<>();
    }

    public void addSongPlaylist(Song song) {
        songsPlaylist.add(song);
    }

    public void deleteSongPlaylist(Song song) {
        for (Song item : songsPlaylist) {
            if (item.equals(song)) {
                songsPlaylist.remove(song);
            }
            break;
        }
    }

    public int getSongLongPlaylistSize() {
        int sizeSongsWithPlaylist = 0;
        for (Song item : songsPlaylist) {
            sizeSongsWithPlaylist += item.getSecondsPlaySong();
        }
        return sizeSongsWithPlaylist;
    }

    public List<Song> getSongs() {
        return songsPlaylist;
    }

    @Override
    public String toString() {
        return "Playlist{" + "songsPlaylist=" + songsPlaylist + '}';
    }
}