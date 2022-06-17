package com.example.notatnik;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "room_note")
public class Note {

    @PrimaryKey
    private Long nr;

    private String text;
    private String date;

    public Note(String text, String date) {
        this.text = text;
        this.date = date;
    }

//    public Note(Long nr, String text, String date) {
//        this.nr = nr;
//        this.text = text;
//        this.date = date;
//    }

    @Override
    public String toString() {
        return "Note{" +
                "nr=" + nr +
                ", text='" + text + '\'' +
                ", date=" + date +
                '}';
    }

    public Long getNr() {
        return nr;
    }

    public void setNr(Long nr) {
        this.nr = nr;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
