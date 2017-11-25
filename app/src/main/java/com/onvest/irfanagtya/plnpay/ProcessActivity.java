package com.onvest.irfanagtya.plnpay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ProcessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process);
    }

    public void activityIDCheck(View view) {
        Intent Intent = new Intent(this, IdCekActivity.class);
        startActivity(Intent);
    }

    public void activityPay(View view) {
        Intent Intent = new Intent(this, PayActivity.class);
        startActivity(Intent);
    }

    public void activityDone(View view) {
        Intent Intent = new Intent(this, DoneActivity.class);
        startActivity(Intent);
    }
}
