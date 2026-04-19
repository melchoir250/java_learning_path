package mock_interviews.task11;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Song song1 = new Song("8 Mile", "Eminem", 300);
        Song song2 = new Song("Believer", "Imagine Dragons", 204);
        Song song3 = new Song("Numb", "Linkin Park", 185);
        Song song4 = new Song("Halo", "Beyonce", 261);
        Song song5 = new Song("Bohemian Rhapsody", "Queen", 355);
        Song song6 = new Song("Shape of You", "Ed Sheeran", 233);
        Song song7 = new Song("Rolling in the Deep", "Adele", 228);
        Song song8 = new Song("Stairway to Heaven", "Led Zeppelin", 482);
        Song song9 = new Song("Billie Jean", "Michael Jackson", 294);
        Song song10 = new Song("Smells Like Teen Spirit", "Nirvana", 301);

        List<Song> songs = List.of(song1, song2, song3, song4, song5, song6, song7, song8, song9, song10);

        Playlist playlist = new Playlist();

        for (Song item : songs) {
            playlist.addSongPlaylist(item);
        }
        
        System.out.println(playlist.getSongs());
        System.out.println(playlist.getSongLongPlaylistSize());
    }
}