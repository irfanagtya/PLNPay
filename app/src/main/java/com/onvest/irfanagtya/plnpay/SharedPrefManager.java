package com.onvest.irfanagtya.plnpay;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.wifi.WifiManager;

/**
 * Created by raika on 11/21/2017.
 */

//here for this class we are using a singleton pattern
public class SharedPrefManager {

    //the constants
    private static final String SHARED_PREF_NAME = "raikasharedpref";
    private static final String KEY_NAMA_LENGKAP = "keynamalengkap";
    private static final String KEY_NO_HP = "keynohp";
    private static final String KEY_EMAIL = "keyemail";
    private static final String KEY_KODE_REF = "keykoderef";
    private static final String KEY_USER_ID = "keyuserid";
    private static final String PREF_LOGIN = "login";

    private SharedPreferences sharedPreferences;
    private Context mCtx;

    public SharedPrefManager(Context context) {
        mCtx = context;
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

    }

    //method to let the user login
    //this method will store the user data in shared preferences
//    public void userLogin(User user) {
//        sharedPreferences.edit().putInt(KEY_USER_ID, user.getIdUser()).apply();
//        sharedPreferences.edit().putString(KEY_NAMA_LENGKAP, user.getNamaLengkap()).apply();
//        sharedPreferences.edit().putString(KEY_NO_HP, user.getNoHP()).apply();
//        sharedPreferences.edit().putString(KEY_EMAIL, user.getEmail()).apply();
//        sharedPreferences.edit().putInt(KEY_KODE_REF, user.getKodeRef()).apply();
//    }

    public void setLogin(boolean login) {
        sharedPreferences.edit().putBoolean(PREF_LOGIN, login).apply();
    }

    //this method will checker whether user is already logged in or not
    public boolean isLoggedIn() {
        return sharedPreferences.getBoolean(PREF_LOGIN, false);
    }

    public String getUserEmail() {
        return sharedPreferences.getString(KEY_EMAIL, null);
    }

    //this method will give the logged in user
    public User getUser() {
        return new User(
                sharedPreferences.getInt(KEY_USER_ID, 0),
                sharedPreferences.getString(KEY_NAMA_LENGKAP, null),
                sharedPreferences.getString(KEY_NO_HP, null),
                sharedPreferences.getString(KEY_EMAIL, null),
                sharedPreferences.getInt(KEY_KODE_REF, 0)
        );
    }

    //this method will logout the user
    public void logout() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        mCtx.startActivity(new Intent(mCtx, LoginActivity.class));
    }
}