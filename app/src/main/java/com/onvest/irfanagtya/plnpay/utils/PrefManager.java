package com.onvest.irfanagtya.plnpay.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.onvest.irfanagtya.plnpay.User;

/**
 * Created by shoddiq on 25/11/17.
 */

public class PrefManager {
    private static final String PREF_NAME = "com.onvest.irfanagtya.plnpay";
    private static final String PREF_NAMA_LENGKAP = "keynamalengkap";
    private static final String PREF_NO_HP = "keynohp";
    private static final String PREF_EMAIL = "keyemail";
    private static final String PREF_KODE_REF = "keykoderef";
    private static final String PREF_USER_ID = "keyuserid";
    private static final String PREF_LOGIN = "login";
    private SharedPreferences preferences;

    public PrefManager(Context context) {
        preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public void saveUser(User user) {
        preferences.edit().putInt(PREF_USER_ID, user.getId_user()).apply();
        preferences.edit().putString(PREF_NAMA_LENGKAP, user.getNama_lengkap()).apply();
        preferences.edit().putString(PREF_EMAIL, user.getEmail()).apply();
        preferences.edit().putString(PREF_NO_HP, user.getNo_hp()).apply();
        preferences.edit().putInt(PREF_KODE_REF, user.getKode_ref()).apply();
    }

    public User getUser() {
        return new User(
                preferences.getInt(PREF_USER_ID, 0),
                preferences.getString(PREF_NAMA_LENGKAP, null),
                preferences.getString(PREF_NO_HP, null),
                preferences.getString(PREF_EMAIL, null),
                preferences.getInt(PREF_KODE_REF, 0)
        );
    }

    public void setLogin(boolean login) {
        preferences.edit().putBoolean(PREF_LOGIN, login).apply();
    }

    public boolean isLoggedIn() {
        return preferences.getBoolean(PREF_LOGIN, false);
    }
}
