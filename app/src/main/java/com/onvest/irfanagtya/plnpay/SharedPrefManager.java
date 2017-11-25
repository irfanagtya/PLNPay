package com.onvest.irfanagtya.plnpay;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

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

    private static SharedPrefManager mInstance;
    private static Context mCtx;

    public SharedPrefManager(Context context) {
        mCtx = context;
    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }

    //method to let the user login
    //this method will store the user data in shared preferences
    public void userLogin(User user) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_USER_ID, user.getIdUser());
        editor.putString(KEY_NAMA_LENGKAP, user.getNamaLengkap());
        editor.putString(KEY_NO_HP, user.getNoHP());
        editor.putString(KEY_EMAIL, user.getEmail());
        editor.putInt(KEY_KODE_REF, user.getKodeRef());
        editor.apply();
    }

    public void setLogin(boolean login) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        sharedPreferences.edit().putBoolean(PREF_LOGIN, login).apply();
    }

    //this method will checker whether user is already logged in or not
    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(PREF_LOGIN, false);
    }

    //this method will give the logged in user
    public User getUser() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new User(
                sharedPreferences.getInt(KEY_USER_ID, -1),
                sharedPreferences.getString(KEY_NAMA_LENGKAP, null),
                sharedPreferences.getString(KEY_NO_HP, null),
                sharedPreferences.getString(KEY_EMAIL, null),
                sharedPreferences.getInt(KEY_KODE_REF, 0)
        );
    }

    //this method will logout the user
    public void logout() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        mCtx.startActivity(new Intent(mCtx, LoginActivity.class));
    }
}