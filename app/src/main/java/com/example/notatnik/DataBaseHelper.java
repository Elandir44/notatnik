package com.example.notatnik;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.LinkedList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {

    public DataBaseHelper(Context context) {
        super(context, "notatki.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(
                "CREATE TABLE NOTATKI(" +
                        "NR INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "TEKST CHAR(200)," +
                        "DATE CHAR(40));" +
                        "");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

        public void addNote(Note note) {
            SQLiteDatabase db = getWritableDatabase();
            ContentValues wartosci = new ContentValues();
            wartosci.put("tekst", note.getText());
            wartosci.put("date", note.getDate());
            db.insertOrThrow("notatki", null, wartosci);
        }

//
//
//    public void dodajKontakt(Kontakt kontakt){
//        SQLiteDatabase db = getWritableDatabase();
//        ContentValues wartosci = new ContentValues();
//        wartosci.put("imie", kontakt.getImie());
//        wartosci.put("nazwisko",kontakt.getNazwisko());
//        wartosci.put("telefon", kontakt.getTelefon());
//        db.insertOrThrow("telefony",null, wartosci);
//    }
//
//    public void kasujKontakt(int id){
//        SQLiteDatabase db = getWritableDatabase();
//        String[] argumenty={""+id};
//        db.delete("telefony", "nr=?", argumenty);
//    }
//
//
//    public void aktualizujKontakt(Kontakt kontakt){
////        SQLiteDatabase db = getWritableDatabase();
////        ContentValues wartosci = new ContentValues();
////        wartosci.put("imie", kontakt.getImie());
////        wartosci.put("nazwisko",kontakt.getNazwisko());
////        wartosci.put("telefon", kontakt.getTelefon());
////        String args[]={String.valueOf(kontakt.getNr())};
////        db.update("telefony", wartosci, "nr=
//
//        SQLiteDatabase db = getWritableDatabase();
//        db.execSQL("UPDATE TELEFONY SET "
//                + "imie = '" + kontakt.getImie()
//                + "', nazwisko = '" + kontakt.getNazwisko()
//                + "', telefon = '" + kontakt.getTelefon() + "' WHERE nr = " + String.valueOf(kontakt.getNr()));
//
//    }
//
////    public List<Kontakt> dajWszystkie(){
//        List<Kontakt> kontakty = new LinkedList<Kontakt>();
//        String[] kolumny={"nr","imie","nazwisko","telefon"};
//        SQLiteDatabase db = getReadableDatabase();
//        Cursor kursor =db.query("telefony",kolumny,null,null,null,null,null);
//        while(kursor.moveToNext()){
//            Kontakt kontakt = new Kontakt();
//            kontakt.setNr(kursor.getLong(0));
//            kontakt.setImie(kursor.getString(1));
//            kontakt.setNazwisko(kursor.getString(2));
//            kontakt.setTelefon(kursor.getString(3));
//            kontakty.add(kontakt);
//        }
//        return kontakty;
//    }
//
//    public Kontakt dajKontakt(int nr){
//
//        Kontakt kontakt=new Kontakt();
//        SQLiteDatabase db = getReadableDatabase();
//        String[] kolumny={"nr","imie","nazwisko","telefon"};
//        String args[]={nr+""};
//        Cursor kursor=db.query("telefony",kolumny," nr=?",args,null,null,null,null);
//        if(kursor!=null){
//            kursor.moveToFirst();
//            kontakt.setNr(kursor.getLong(0));
//            kontakt.setImie(kursor.getString(1));
//            kontakt.setNazwisko(kursor.getString(2));
//            kontakt.setTelefon(kursor.getString(3));
//        }
//        return kontakt;
//    }
//
//    public List<Kontakt> dajPoNazwisku(String nazwisko){
//        List<Kontakt> kontakty = new LinkedList<Kontakt>();
//        SQLiteDatabase db = getReadableDatabase();
//        Cursor kursor =db.rawQuery("SELECT NR,IMIE,NAZWISKO,TELEFON FROM TELEFONY WHERE NAZWISKO='"
//                +nazwisko+"' ORDER BY NAZWISKO ASC", null);
//        //Cursor kursor =db.rawQuery
//        //("select nr,imie,nazwisko,telefon from telefony where nazwisko=?	order by nazwisko asc", nazwisko);
//        while(kursor.moveToNext()){
//            Kontakt kontakt = new Kontakt();
//            kontakt.setNr(kursor.getLong(0));
//            kontakt.setImie(kursor.getString(1));
//            kontakt.setNazwisko(kursor.getString(2));
//            kontakt.setTelefon(kursor.getString(3));
//            kontakty.add(kontakt);
//        }
//        return kontakty;
//    }

}
