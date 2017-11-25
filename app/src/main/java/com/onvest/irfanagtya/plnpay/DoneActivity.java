package com.onvest.irfanagtya.plnpay;

import android.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class DoneActivity extends AppCompatActivity {

    Fragment fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done);

        FloatingActionButton floatButton = (FloatingActionButton)findViewById(R.id.floatButton);

        //And the layout we want to change is visibility
        final FloatingActionButton floatShare = (FloatingActionButton) findViewById(R.id.floatShare);
        final FloatingActionButton floatDownload = (FloatingActionButton) findViewById(R.id.floatDownload);

        floatButton.setOnClickListener (
                new View.OnClickListener() {
                    public void onClick(View v) {
                        if (floatShare.getVisibility() == View.VISIBLE) {
                            floatShare.setVisibility(View.INVISIBLE);
                            floatDownload.setVisibility(View.INVISIBLE);
                        }else{
                            floatShare.setVisibility(View.VISIBLE);
                            floatDownload.setVisibility(View.VISIBLE);
                        }
                    }
                }
        );
    }
}
