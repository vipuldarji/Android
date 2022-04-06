package com.example.myapplication.dbdao;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "song")
public class Song {

    @PrimaryKey(autoGenerate=true)
    @ColumnInfo(name="song_id")
    private int songId;

    @ColumnInfo(name="song_name")
    private String songName;

    @ColumnInfo(name="song_image")
    private String songImage;

    @ColumnInfo(name="song_desc")
    private String songDesc;

    @ColumnInfo(name="song_price")
    private String songPrice;

    public Song() {
    }

    public Song(int songId, String songName, String songDesc, String songPrice, String songImage) {
        this.songId = songId;
        this.songName = songName;
        this.songDesc = songDesc;
        this.songPrice = songPrice;
        this.songImage = songImage;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongImage() {
        return songImage;
    }

    public void setSongImage(String songImage) {
        this.songImage = songImage;
    }

    public String getSongDesc() {
        return songDesc;
    }

    public void setSongDesc(String songDesc) {
        this.songDesc = songDesc;
    }

    public String getSongPrice() {
        return songPrice;
    }

    public void setSongPrice(String songPrice) {
        this.songPrice = songPrice;
    }

    //@NonNull
    @Override
    public String toString() {

        return "Payment{" +
                "songId=" + songId +
                ", songName='" + songName + '\'' +
                ", songDesc='" + songDesc + '\'' +
                ", songPrice='" + songPrice + '\'' +
                ", songImage='" + songImage + '\'' +
                '}';
    }
}
