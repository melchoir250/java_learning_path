package chapter_06_oop_principles.media_player;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Podcast podcast1 = new Podcast("HUSTLE SHOW", "Tambi, Adam");
        Podcast podcast2 = new Podcast("Tech Talks", "Lex Fridman");
        Podcast podcast3 = new Podcast("True Crime Stories", "Elena Raitman");
        Podcast podcast4 = new Podcast("Startup Stories", "Y Combinator");

        Song song1 = new Song("crime", "N1NT3ND0");
        Song song2 = new Song("Blinding Lights", "The Weeknd");
        Song song3 = new Song("Mockingbird", "Eminem");
        Song song4 = new Song("Skyfall", "Adele");
        Song song5 = new Song("Believer", "Imagine Dragons");

        Audiobook audiobook1 = new Audiobook("1984", "George Orwell");
        Audiobook audiobook2 = new Audiobook("Atomic Habits", "James Clear");
        Audiobook audiobook3 = new Audiobook("Clean Code", "Robert C. Martin");
        Audiobook audiobook4 = new Audiobook("The Hobbit", "J.R.R. Tolkien");

        List<Playable> media = List.of(
                podcast1, podcast2, podcast3, podcast4,
                song1, song2, song3, song4, song5,
                audiobook1, audiobook2, audiobook3, audiobook4
        );

        Player player = new Player();
        for (Playable playable : media) {
            player.addPlayable(playable);
        }

        player.playAll();
    }
}