package com.onvest.irfanagtya.plnpay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void activityIDCek(View view) {
        Intent Intent = new Intent(this, IdCekActivity.class);
        startActivity(Intent);
    }

    public void activityProfil(View view) {
        Intent Intent = new Intent(this, ProfilActivity.class);
        startActivity(Intent);
    }
}
