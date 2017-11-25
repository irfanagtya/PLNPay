package com.onvest.irfanagtya.plnpay.model.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by shoddiq on 25/11/17.
 */

public class LoginRequest {
    private String email;
    private String password;

    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
