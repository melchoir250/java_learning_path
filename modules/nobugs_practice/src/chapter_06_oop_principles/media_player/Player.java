package chapter_06_oop_principles.media_player;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final List<Playable> playables = new ArrayList<>();

    public void addPlayable(Playable playable) {
        playables.add(playable);
    }

    public void playAll() {
        for (Playable playable : playables) {
            playable.play();
        }
    }
}