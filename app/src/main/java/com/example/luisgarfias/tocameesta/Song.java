package com.example.luisgarfias.tocameesta;

public class Song {

    // Define type Genre and add the only five options to have in the main activity
    enum Genre {
        BANDA, MARIACHI, ROCK, RANCHERAS, HIPHOP;
    }

    private String mSongName;
    private String mArtistName;
    private String mArtUri;
    private Genre mGenre;

    public Song(String mSongName, String mArtistName, String mArtUri, Genre mGenre) {
        this.mSongName = mSongName;
        this.mArtistName = mArtistName;
        this.mArtUri = mArtUri;
        this.mGenre = mGenre;
    }

    public String getmSongName() {
        return mSongName;
    }

    public void setmSongName(String mSongName) {
        this.mSongName = mSongName;
    }

    public String getmArtistName() {
        return mArtistName;
    }

    public void setmArtistName(String mArtistName) {
        this.mArtistName = mArtistName;
    }

    public String getmArtUri() {
        return mArtUri;
    }

    public void setmArtUri(String mArtUri) {
        this.mArtUri = mArtUri;
    }

    public Genre getmGenre() {
        return mGenre;
    }

    public void setmGenre(Genre mGenre) {
        this.mGenre = mGenre;
    }
}


