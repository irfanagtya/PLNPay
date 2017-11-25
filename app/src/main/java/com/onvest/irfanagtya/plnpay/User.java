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

    }

    public User(int id_user, String nama_lengkap, String no_hp, String email) {
    }

    public int getIdUser() {
        return id_user;
    }

    public String getNamaLengkap() {
        return nama_lengkap;
    }

    public String getNoHP() {
        return no_hp;
    }

    public String getEmail() {
        return email;
    }

    public int getKodeRef() {
        return kode_ref;
    }
}