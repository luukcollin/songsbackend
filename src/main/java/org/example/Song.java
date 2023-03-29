package org.example;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Song {
    public Song(){}

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", artist='" + artist + '\'' +
                ", title='" + title + '\'' +
                ", starred=" + starred +
                ", created=" + created +
                ", genre=" + genre +
                '}';
    }

    public Song(int id, String artist, String title, long created, boolean starred, String genre) {
        this.id = id;
        this.artist = artist;
        this.title = title;
        this.starred = starred;
        this.created = created;
        this.genre = genre;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "artist")
    private String artist;

    @Column(name = "title")
    private String title;

    @Column(name = "starred")
    private boolean starred;
    @Column(name="created")
    private long created;

    @Column(name="genre")
    private String genre;

    public String getArtist() {
        return artist;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public long getCreated() {
        return created;
    }

    public boolean getStarred() {return starred;}

    public String getGenre() {return genre;}
}