package com.onvest.irfanagtya.plnpay.model.response;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("error")
    private boolean error;

    @SerializedName("message")
    private String message;

    @SerializedName("user")
    private User user;

    public void setError(boolean error) {
        this.error = error;
    }

    public boolean isError() {
        return error;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return
                "LoginResponse{" +
                        "error = '" + error + '\'' +
                        ",message = '" + message + '\'' +
                        ",user = '" + user + '\'' +
                        "}";
    }
}