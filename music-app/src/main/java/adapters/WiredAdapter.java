package adapters;

import apis.WiredAPI;
import models.Song;

public class WiredAdapter implements AudioInterface {
    private WiredAPI wired;

    public WiredAdapter(WiredAPI wired){
        this.wired = wired;
    }

    public void play(Song s){
        wired.start(s);
    }
}
