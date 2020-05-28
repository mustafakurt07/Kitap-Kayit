package com.example.kitapkayit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private boolean fab_status=false;
    private Animation fab_acik,fab_kapali,ileri_don,geri_don;
    private RecyclerView rv;
    private FloatingActionButton fab,fabAdd,fabStatics;
    private  kitapAdapter adapter;
    private ArrayList<Kitaplar>kitaplarArrayList;
    private Veritabani vt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbarMain);
        toolbar.setTitle("Okunan Kitaplar");
        setSupportActionBar(toolbar);
        fabAdd=findViewById(R.id.fabAdd);
        fabStatics=findViewById(R.id.fabStat);
        fab_acik= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_acik);
        fab_kapali=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_kapali);
        ileri_don=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.ileri_don);
        geri_don=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.geri_don);
        rv=findViewById(R.id.rv);
        fab=findViewById(R.id.floatingActionButton);
        vt=new Veritabani(this);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        kitaplarArrayList=new kitaplarDAO().tumKitaplar(vt);
        int toplam=0;
        for(Kitaplar kitaplar:kitaplarArrayList)
        {
            toplam=toplam+(kitaplar.getSayfa_sayisi());
        }
        toolbar.setSubtitle("Ortalama Okunan Sayfa:"+(toplam/kitaplarArrayList.size()));
        adapter=new kitapAdapter(this,kitaplarArrayList);
        rv.setAdapter(adapter);
/*
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this,KitapAdd.class));

            }
        });*/
      fabTikla();
    }
    public void fabTikla()
    {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fab_status)
                {
                    fab.startAnimation(geri_don);
                    fabAdd.startAnimation(fab_kapali);
                    fabStatics.startAnimation(fab_kapali);
                    fabAdd.setClickable(false);
                    fabStatics.setClickable(false);
                    fab_status=false;

                }
                else
                //tıklanıldıgında kontrol
                {
                    fab.startAnimation(ileri_don);
                    fabAdd.startAnimation(fab_acik);
                    fabStatics.startAnimation(fab_acik);
                    fabAdd.setClickable(true);
                    fabStatics.setClickable(true);
                    fabAdd.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(MainActivity.this,KitapAdd.class));
                        }
                    });
                    fabStatics.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(MainActivity.this,StaticsActivity.class));

                        }
                    });
                    fab_status=true;

                }


            }
        });
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
