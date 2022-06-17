package com.example.notatnik;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    private ListView list ;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.list);
        RoomNoteDatabase db = RoomNoteDatabase.getDatabase(this);
        RoomDao roomDao = db.roomDao();
        RoomNoteDatabase.databaseWriteExecutor.execute(() -> {
// roomDao.deleteAll();
//            roomDao.insertAll(new Note( "Kowalski", "2022-06-11"),
//                    new Note( "Nowak", "2022-06-11"));
        });

            LiveData<List<Note>> kontakts = roomDao.getAll();
            kontakts.observe(this, words -> {
                words.forEach(
                        w -> {
                            Log.d("DB", w.toString());
                        }
                );
                ArrayAdapter<Note> adapter = new ArrayAdapter<Note>(this, android.R.layout.simple_list_item_1, words);
                list.setAdapter(adapter);
            });
        }

        




//    public void wyswietl(View view) {
//
//
//    }



    public void dodajNotatke(View view) {
        Intent intent = new Intent(this, DodajNotatke.class);
        startActivity(intent);

    }

}