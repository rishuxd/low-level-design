package models;

import java.util.ArrayList;
import java.util.List;

import enums.Visibility;

public class Playlist {
    private String name;
    private Visibility visibility;
    List<Song> songs = new ArrayList<>();

    public Playlist(String name, Visibility visibility){
        this.name = name;
        this.visibility = visibility;
    }

    //getters
    public String getName(){ return name; }
    public Visibility getVisibility(){ return visibility; }
    public List<Song> getSongs(){ return songs; }

    //setters
    public void setName(String name){ this.name = name; }
    public void setVisibility(Visibility visibility){ this.visibility = visibility; }

    public void addSong(Song s){
        songs.add(s);
    }
    
    public void removeSong(Song s){
        songs.remove(s);
    }
}
