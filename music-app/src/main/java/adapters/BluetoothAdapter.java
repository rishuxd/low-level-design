package adapters;

import apis.BluetoothAPI;
import models.Song;

public class BluetoothAdapter implements AudioInterface {
    private BluetoothAPI bt;

    public BluetoothAdapter(BluetoothAPI bt){
        this.bt = bt;
    }
    
    public void play(Song s){
        bt.playSong(s);
    }
} 
