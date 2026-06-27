package strategies;

import java.util.List;

import models.Song;

public class CustomStrategy implements PlayingStrategy {
    private List<Song> list;

    public CustomStrategy(List<Song> list) {
        this.list = list;
    }

    @Override
    public Song getNext(List<Song> songs, int currentIndex) {
        if (currentIndex == list.size() - 1)
            return list.get(0);
        return list.get(currentIndex + 1);
    }

    @Override
    public Song getPrev(List<Song> songs, int currentIndex) {
        if (currentIndex == 0)
            return list.get(list.size() - 1);
        return list.get(currentIndex - 1);
    }

    public void addSong(Song song) {
        list.add(song);
    }

    public void addSongAt(int index, Song song) {
        list.add(index, song);
    }

    public void removeSong(Song song) {
        list.remove(song);
    }
}
