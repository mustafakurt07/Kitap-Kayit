package com.example.kitapkayit;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class kitapAdapter extends  RecyclerView.Adapter<kitapAdapter.CardTasarim> {
    private Context myContext;
    private List<Kitaplar>kitaplarList;

    public kitapAdapter(Context myContext, List<Kitaplar> kitaplarList) {
        this.myContext = myContext;
        this.kitaplarList = kitaplarList;
    }

    @NonNull
    @Override
    public CardTasarim onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_tasarim,parent,false);

        return new CardTasarim(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarim holder, int position) {
       final  Kitaplar kitaplar=kitaplarList.get(position);
        holder.textViewKitap.setText(kitaplar.getKitap_adi());
        holder.textViewYazar.setText(kitaplar.getYazar_adi());
        holder.textViewSayfa.setText(String.valueOf(kitaplar.getSayfa_sayisi()));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent git=new Intent(myContext,DetailActivity.class);
                git.putExtra("nesne",kitaplar);
                myContext.startActivity(git);
            }
        });


    }

    @Override
    public int getItemCount() {
        return kitaplarList.size();
    }

    public class CardTasarim extends RecyclerView.ViewHolder{
        private TextView  textViewKitap;
        private  TextView textViewYazar;
        private  TextView textViewSayfa;
        private CardView cardView;


        public CardTasarim(@NonNull View itemView) {
            super(itemView);
            textViewKitap=itemView.findViewById(R.id.textViewKitap);
            textViewYazar=itemView.findViewById(R.id.textViewYazar);
            textViewSayfa=itemView.findViewById(R.id.textViewSayfa);
            cardView=itemView.findViewById(R.id.kitap_card);
        }
    }
}
