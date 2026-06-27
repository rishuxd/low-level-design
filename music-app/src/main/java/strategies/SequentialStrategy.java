package strategies;

import java.util.List;
import models.Song;

public class SequentialStrategy implements PlayingStrategy {
    @Override
    public Song getNext(List<Song> songs, int currentIndex) {
        if (currentIndex == songs.size() - 1)
            return songs.get(0);
        return songs.get(currentIndex + 1);
    }

    @Override
    public Song getPrev(List<Song> songs, int currentIndex) {
        if (currentIndex == 0)
            return songs.get(songs.size() - 1);
        return songs.get(currentIndex - 1);
    }
}
