package apis;

import models.Song;

public class BluetoothAPI {
    public void playSong(Song s) {
        System.out.println("Playing '" + s.getName() + "' by " + s.getArtist() + " through BT Speaker!");
    }
}
