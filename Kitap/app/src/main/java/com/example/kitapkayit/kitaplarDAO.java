package com.example.kitapkayit;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class kitaplarDAO  {
    public ArrayList<Kitaplar>tumKitaplar(Veritabani vt)
    {
        ArrayList<Kitaplar>kitaplarArrayList=new ArrayList<>();
        SQLiteDatabase db=vt.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM books",null);
        while(cursor.moveToNext())
        {
            Kitaplar kt= new Kitaplar (cursor.getInt(cursor.getColumnIndex("kitap_id"))
                    ,cursor.getString(cursor.getColumnIndex("kitap_adi"))
                    ,cursor.getString(cursor.getColumnIndex("yazar_adi"))
                    ,cursor.getInt(cursor.getColumnIndex("sayfa_sayisi")));
            kitaplarArrayList.add(kt);
        }
        return kitaplarArrayList;
    }
    public void kitapSil(Veritabani vt,int kitap_id)
    {
        SQLiteDatabase db=vt.getWritableDatabase();
        db.delete("books","kitap_id=?",new String[]{String.valueOf(kitap_id)});
        db.close();
    }
    public void kitapEkle(Veritabani vt,String kitap_adi,String yazar_adi,int sayfa_sayisi)
    {
        SQLiteDatabase dbx=vt.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("kitap_adi",kitap_adi);
        cv.put("yazar_adi",yazar_adi);
        cv.put("sayfa_sayisi",sayfa_sayisi);
        dbx.insertOrThrow("books",null,cv);
        dbx.close();

    }
    public void kitapDuzenle(Veritabani vt,int kitap_id,String kitap_adi,String yazar_adi,int sayfa_sayisi)
    {
        SQLiteDatabase dbx=vt.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("kitap_adi",kitap_adi);
        cv.put("yazar_adi",yazar_adi);
        cv.put("sayfa_sayisi",sayfa_sayisi);
        dbx.update("books",cv,"kitap_id=?",new String[]{String.valueOf(kitap_id)});
        dbx.close();
    }
    public void sayfaAl(Veritabani vt, ArrayList<ContentValues> sayfa, int sayfa_sayisi)
    {


        SQLiteDatabase dby=vt.getReadableDatabase();
        ContentValues cv=new ContentValues();
        cv.get((String.valueOf(sayfa_sayisi)));
        sayfa.add(cv);
    }
}
