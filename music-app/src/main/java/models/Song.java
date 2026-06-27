package models;

public class Song {
    private String name;
    private String artist;
    private String url;

    public Song(String name, String artist, String url){
        this.name = name;
        this.artist = artist;
        this.url = url;
    }

    //getters
    public String getName(){ return name; }
    public String getArtist(){ return artist; }
    public String getUrl(){ return url; }
}
