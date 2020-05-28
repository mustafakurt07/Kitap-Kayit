package com.example.kitapkayit;

import java.io.Serializable;

public class Kitaplar implements Serializable {
    private  int kitap_id;
    private  String kitap_adi;
    private String yazar_adi;
    private  int sayfa_sayisi;

    public Kitaplar() {
    }

    public Kitaplar(int kitap_id, String kitap_adi, String yazar_adi, int sayfa_sayisi) {
        this.kitap_id = kitap_id;
        this.kitap_adi = kitap_adi;
        this.yazar_adi = yazar_adi;
        this.sayfa_sayisi = sayfa_sayisi;
    }

    public int getKitap_id() {
        return kitap_id;
    }

    public void setKitap_id(int kitap_id) {
        this.kitap_id = kitap_id;
    }

    public String getKitap_adi() {
        return kitap_adi;
    }

    public void setKitap_adi(String kitap_adi) {
        this.kitap_adi = kitap_adi;
    }

    public String getYazar_adi() {
        return yazar_adi;
    }

    public void setYazar_adi(String yazar_adi) {
        this.yazar_adi = yazar_adi;
    }

    public int getSayfa_sayisi() {
        return sayfa_sayisi;
    }

    public void setSayfa_sayisi(int sayfa_sayisi) {
        this.sayfa_sayisi = sayfa_sayisi;
    }
}
