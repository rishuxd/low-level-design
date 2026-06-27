package strategies;

import java.util.List;

import models.Song;

public interface PlayingStrategy {
    Song getNext(List<Song> songs, int currentIndex);

    Song getPrev(List<Song> songs, int currentIndex);
}
