package com.example.notatnik;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.time.LocalDateTime;

public class DodajNotatke extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodaj_notatke);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void zapisz(View view) {

        String data = String.valueOf(LocalDateTime.now());

        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();

        RoomNoteDatabase db = RoomNoteDatabase.getDatabase(this);
        RoomDao roomDao = db.roomDao();
        RoomNoteDatabase.databaseWriteExecutor.execute(() -> {

            roomDao.insertAll(new Note( message, data));
        });

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}