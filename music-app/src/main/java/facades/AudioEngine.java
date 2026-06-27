package facades;

import adapters.AudioInterface;
import enums.DeviceType;
import enums.PlayerState;
import managers.DeviceManger;
import models.Playlist;
import models.Song;
import strategies.PlayingStrategy;

public class AudioEngine {

    private PlayerState state;
    private Song currSong;
    private int currIndex;
    private Playlist currPlaylist;
    private PlayingStrategy strategy;
    private AudioInterface device;

    private AudioEngine() {}

    private static class Holder {

        private static final AudioEngine INSTANCE = new AudioEngine();
    }

    public static AudioEngine getInstance() {
        return Holder.INSTANCE;
    }

    public void connect(DeviceType dt) {
        DeviceManger.getInstance().connect(dt);
        device = DeviceManger.getInstance().getDevice();
        System.out.println("[DEVICE] Connected to " + dt + " successfully.");
    }

    public void setStrategy(PlayingStrategy strategy) {
        this.strategy = strategy;
        System.out.println("[STRATEGY] Playback mode set to: " + strategy.getClass().getSimpleName());
    }

    public void play(Song s) {
        if (device == null) {
            System.out.println("[ERROR] No device connected. Please connect a device first.");
            return;
        }
        currSong = s;
        currPlaylist = null;
        state = PlayerState.PLAYING;
        System.out.println("[PLAYER] Playing single song.");
        device.play(s);
    }

    public void play(Playlist pl) {
        if (device == null) {
            System.out.println("[ERROR] No device connected. Please connect a device first.");
            return;
        }
        if (strategy == null) {
            System.out.println("[ERROR] No strategy set. Please select a playback strategy first.");
            return;
        }

        currPlaylist = pl;
        currIndex = 0;
        currSong = strategy.getNext(pl.getSongs(), -1);
        state = PlayerState.PLAYING;
        System.out.println("[PLAYER] Playing playlist: " + pl.getName());
        device.play(currSong);
    }

    public void pause() {
        if (state != PlayerState.PLAYING) return;
        state = PlayerState.PAUSED;
        System.out.println("[PLAYER] Paused: '" + currSong.getName() + "'");
    }

    public void resume() {
        if (state != PlayerState.PAUSED) return;
        state = PlayerState.PLAYING;
        System.out.println("[PLAYER] Resumed: '" + currSong.getName() + "'");
        device.play(currSong);
    }

    public void stop() {
        state = PlayerState.STOPPED;
        currSong = null;
        currPlaylist = null;
        System.out.println("[PLAYER] Stopped.");
    }

    public void next() {
        if (currPlaylist == null || device == null) return;
        currSong = strategy.getNext(currPlaylist.getSongs(), currIndex);
        currIndex = currPlaylist.getSongs().indexOf(currSong);
        state = PlayerState.PLAYING;
        System.out.println("[PLAYER] Skipping to next.");
        device.play(currSong);
    }

    public void prev() {
        if (currPlaylist == null || device == null) return;
        currSong = strategy.getPrev(currPlaylist.getSongs(), currIndex);
        currIndex = currPlaylist.getSongs().indexOf(currSong);
        state = PlayerState.PLAYING;
        System.out.println("[PLAYER] Going to previous.");
        device.play(currSong);
    }
}
