package com.onvest.irfanagtya.plnpay.model.response;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("no_hp")
    private String phone;

    @SerializedName("nama_lengkap")
    private String name;

    @SerializedName("id_user")
    private int idUser;

    @SerializedName("kode_ref")
    private int ref;

    @SerializedName("email")
    private String email;

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }

    public int getRef() {
        return ref;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return
                "User{" +
                        "no_hp = '" + phone + '\'' +
                        ",nama_lengkap = '" + name + '\'' +
                        ",id_user = '" + idUser + '\'' +
                        ",kode_ref = '" + ref + '\'' +
                        ",email = '" + email + '\'' +
                        "}";
    }
}