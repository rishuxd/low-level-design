package strategies;

import java.util.List;
import java.util.Random;

import models.Song;

public class RandomStrategy implements PlayingStrategy {

    private Song getRandomSong(List<Song> songs, int currentIndex) {
        Random random = new Random();
        int randomIndex;
        do {
            randomIndex = random.nextInt(songs.size());
        } while (randomIndex == currentIndex && songs.size() > 1);
        return songs.get(randomIndex);
    }

    @Override
    public Song getNext(List<Song> songs, int currentIndex) {
        return getRandomSong(songs, currentIndex);
    }

    @Override
    public Song getPrev(List<Song> songs, int currentIndex) {
        return getRandomSong(songs, currentIndex);
    }
}
