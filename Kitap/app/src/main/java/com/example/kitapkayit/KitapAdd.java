package com.example.kitapkayit;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class KitapAdd extends AppCompatActivity {
    private Toolbar toolbar;
    private EditText kitap,yazar,sayfa;
    private Button kaydet;
    private  Veritabani vt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitap_add);
        toolbar=findViewById(R.id.toolbar);
        kitap=findViewById(R.id.editKitap);
        yazar=findViewById(R.id.editYazar);
        sayfa=findViewById(R.id.editSayfa);
        vt=new Veritabani(this);
        toolbar.setTitle("Kitap Kayit");
        setSupportActionBar(toolbar);
        kaydet=findViewById(R.id.buttonKaydet);
        kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kitap_adi=kitap.getText().toString().trim();
                String yazar_adi=yazar.getText().toString().trim();
                String sayfa_sayisi=sayfa.getText().toString().trim();
                if(TextUtils.isEmpty(kitap_adi))
                {
                    Snackbar.make(v,"Kitap adi giriniz",Snackbar.LENGTH_LONG).show();
                    return;
                }
                if(TextUtils.isEmpty(yazar_adi))
                {
                    Snackbar.make(v,"Yazar adi giriniz",Snackbar.LENGTH_LONG).show();
                    return;
                }
                if(TextUtils.isEmpty(sayfa_sayisi))
                {
                    Snackbar.make(v,"Sayfa Sayisi giriniz",Snackbar.LENGTH_LONG).show();
                    return;
                }
                new kitaplarDAO().kitapEkle(vt,kitap_adi,yazar_adi,Integer.parseInt(sayfa_sayisi));
                startActivity(new Intent(KitapAdd.this,MainActivity.class));
                finish();

            }
        });
    }

}
