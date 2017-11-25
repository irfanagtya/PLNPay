package com.onvest.irfanagtya.plnpay;

/**
 * Created by raika on 11/21/2017.
 */

//this is very simple class and it only contains the user attributes, a constructor and the getters
// you can easily do this by right click -> generate -> constructor and getters
public class User {

    private String nama_lengkap, no_hp, email;
    private int id_user, kode_ref;

    public User(int id_user, String nama_lengkap, String no_hp, String email, int kode_ref) {
        this.nama_lengkap = nama_lengkap;
        this.no_hp = no_hp;
        this.email = email;
        this.id_user = id_user;
        this.kode_ref = kode_ref;
    }

    public String getNama_lengkap() {
        return nama_lengkap;
    }

    public void setNama_lengkap(String nama_lengkap) {
        this.nama_lengkap = nama_lengkap;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getKode_ref() {
        return kode_ref;
    }

    public void setKode_ref(int kode_ref) {
        this.kode_ref = kode_ref;
    }
}