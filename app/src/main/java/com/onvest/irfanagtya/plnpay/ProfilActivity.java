package com.onvest.irfanagtya.plnpay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ProfilActivity extends AppCompatActivity {

    TextView profilUserID, profilName, profilHP, profilEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        //if the user is not logged in
        //starting the login activity
        if (!SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }

        profilUserID = (TextView) findViewById(R.id.profilUserID);
        profilName = (TextView) findViewById(R.id.profilName);
        profilHP = (TextView) findViewById(R.id.profilHP);
        profilEmail = (TextView) findViewById(R.id.profilEmail);

        //getting the current user
        User user = SharedPrefManager.getInstance(this).getUser();

        //setting the values to the textviews
        profilUserID.setText(String.valueOf(user.getIdUser()));
        profilName.setText(user.getNamaLengkap());
        profilHP.setText(user.getNoHP());
        profilEmail.setText(user.getEmail());

        //when the user presses logout button
        //calling the logout method
        findViewById(R.id.floatLogout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                SharedPrefManager.getInstance(getApplicationContext()).logout();
            }
        });
    }

    public void activityTambahIDPel(View view) {
        Intent Intent = new Intent(this, TambahIDPelActivity.class);
        startActivity(Intent);
    }
}
