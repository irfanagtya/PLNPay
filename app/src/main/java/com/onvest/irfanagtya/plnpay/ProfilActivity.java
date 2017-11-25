package com.onvest.irfanagtya.plnpay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.onvest.irfanagtya.plnpay.utils.PrefManager;

public class ProfilActivity extends AppCompatActivity {

    TextView profilUserID, profilName, profilHP, profilEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        final PrefManager prefManager = new PrefManager(this);
        //if the user is not logged in
        //starting the login activity

        profilUserID = findViewById(R.id.profilUserID);
        profilName = findViewById(R.id.profilName);
        profilHP = findViewById(R.id.profilHP);
        profilEmail = findViewById(R.id.profilEmail);

        User user = prefManager.getUser();
        Log.d("email", user.getEmail());
//
        //setting the values to the textviews
        profilUserID.setText(String.valueOf(user.getId_user()));
        profilName.setText(user.getNama_lengkap());
        profilHP.setText(user.getNo_hp());
        profilEmail.setText(user.getEmail());

        //when the user presses logout button
        //calling the logout method
//        findViewById(R.id.floatLogout).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                prefManager.logout();
//                finish();
//            }
//        });
    }

    public void activityTambahIDPel(View view) {
        Intent Intent = new Intent(this, TambahIDPelActivity.class);
        startActivity(Intent);
    }
}
