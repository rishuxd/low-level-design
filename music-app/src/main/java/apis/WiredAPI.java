package apis;

import models.Song;

public class WiredAPI {
    public void start(Song s) {
        System.out.println("Playing '" + s.getName() + "' by " + s.getArtist() + " through Wired Speaker!");
    }
}
