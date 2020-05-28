package com.example.kitapkayit;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class Veritabani extends SQLiteOpenHelper {
    //@RequiresApi(api = Build.VERSION_CODES.P)
    public Veritabani(@Nullable Context context) {
        super(context, "books.sqlite" ,null ,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE \"books\" (\n" +
                "\t\"kitap_id\"\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t\"kitap_adi\"\tTEXT,\n" +
                "\t\"yazar_adi\"\tTEXT,\n" +
                "\t\"sayfa_sayisi\"\tINTEGER\n" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS books");
        onCreate(db);

    }
}
