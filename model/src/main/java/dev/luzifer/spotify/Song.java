package dev.luzifer.spotify;

public class Song {
    
    private final String url;
    private final SongInformation songInformation;
    
    public Song(String url) {
        this.url = url;
        this.songInformation = new SongInformation(); // fetch information from spotify and set it here
    }
    
}
