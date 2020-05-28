package com.example.kitapkayit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class DetailActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private EditText kitap,yazar,sayfa;
    private Kitaplar kitaplar;
    private  Veritabani vt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        toolbar=findViewById(R.id.toolbarDetail);
        kitap=findViewById(R.id.editKitap3);
        yazar=findViewById(R.id.editYazar3);
        sayfa=findViewById(R.id.editSayfa3);
        vt=new Veritabani(this);
        kitaplar=(Kitaplar)getIntent().getSerializableExtra("nesne");

        toolbar.setTitle("Detail");
        setSupportActionBar(toolbar);
        kitap.setText(kitaplar.getKitap_adi());
        yazar.setText(kitaplar.getYazar_adi());
        sayfa.setText(String.valueOf(kitaplar.getSayfa_sayisi()));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.actionDuzenle:
                String kitap_adi=kitap.getText().toString().trim();
                String yazar_adi=yazar.getText().toString().trim();
              final   String sayfa_sayisi=sayfa.getText().toString().trim();
                if(TextUtils.isEmpty(kitap_adi))
                {
                    Snackbar.make(toolbar,"Kitap adi giriniz",Snackbar.LENGTH_LONG).show();
                    return false;
                }
                if(TextUtils.isEmpty(yazar_adi))
                {
                    Snackbar.make(toolbar,"Yazar adi giriniz",Snackbar.LENGTH_LONG).show();
                    return false;
                }
                if(TextUtils.isEmpty(sayfa_sayisi))
                {
                    Snackbar.make(toolbar,"Sayfa Sayisi giriniz",Snackbar.LENGTH_LONG).show();
                    return false;
                }
                new kitaplarDAO().kitapDuzenle(vt,kitaplar.getKitap_id(),kitap_adi,yazar_adi,Integer.parseInt(sayfa_sayisi));
                startActivity(new Intent(DetailActivity.this,MainActivity.class));
                finish();

                return true;
            case R.id.actionSil:

                Snackbar.make(toolbar,"Silinsin mi",Snackbar.LENGTH_LONG).setAction("Evet", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        new kitaplarDAO().kitapSil(vt,kitaplar.getKitap_id());
                        startActivity(new Intent(DetailActivity.this,MainActivity.class));
                        finish();

                    }
                }).show();
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}
