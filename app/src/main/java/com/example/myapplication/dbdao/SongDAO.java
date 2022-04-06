package com.example.myapplication.dbdao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface SongDAO {
    @Query("select * from song")
    List<Song> getSongList();
    @Insert
    void insertSong(Song ... song);
    @Update
    void updateSong(Song ... song);
    @Delete
    void deleteSong(Song ... song);
    @Query("DELETE FROM song")
    public void deleteSongTable();

}
