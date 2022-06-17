package com.example.notatnik;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface RoomDao {
    @Insert
    void insertAll(Note... roomNotes);
    @Delete
    void delete(Note roomNote);
    @Query("SELECT * FROM room_note")
    LiveData<List<Note>> getAll();
    @Query("DELETE FROM room_note")
    void deleteAll();
}
