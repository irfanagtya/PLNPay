package com.onvest.irfanagtya.plnpay.model.request;

/**
 * Created by shoddiq on 25/11/17.
 */

public class SignupRequest {
    private String name;
    private String phone;
    private String email;
    private String password;
    private int ref;

    public SignupRequest(String name, String phone, String email, String password, int ref) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.ref = ref;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public int getRef() {
        return ref;
    }

    public String getPassword() {
        return password;
    }
}
