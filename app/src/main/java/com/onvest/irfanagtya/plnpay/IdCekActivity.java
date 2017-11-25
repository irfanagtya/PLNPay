package com.onvest.irfanagtya.plnpay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class IdCekActivity extends AppCompatActivity {

    private LinearLayout prabayar, paskabayar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id_cek);

        Button cek_button = (Button) findViewById(R.id.cek_id_button);

        //And the layout we want to change is visibility
        final LinearLayout prabayar = (LinearLayout) findViewById(R.id.prabayar);
        final LinearLayout paskabayar = (LinearLayout) findViewById(R.id.paskabayar);

        cek_button.setOnClickListener (
            new View.OnClickListener() {
                public void onClick(View v) {
                    if (prabayar.getVisibility() == View.VISIBLE) {
                        prabayar.setVisibility(View.GONE);
                    }else{
                        prabayar.setVisibility(View.VISIBLE);
                    }
                }
            }
        );
    }

    public void activityPay(View view) {
        Intent Intent = new Intent(this, PayActivity.class);
        startActivity(Intent);
    }
}
