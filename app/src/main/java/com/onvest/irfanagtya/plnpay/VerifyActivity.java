package com.onvest.irfanagtya.plnpay;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class VerifyActivity extends AppCompatActivity {

    private TextView cdText;

    private CountDownTimer countDownTimer;
    private long timeLeftMilliseconds = 900000; //15 menit
    private boolean timerRunning;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);

        cdText = (TextView)findViewById(R.id.cdText);

        startTimer();
    }

    public void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftMilliseconds, 1000) {
            @Override
            public void onTick(long l) {
                timeLeftMilliseconds = 1;
                updateTimer();
            }

            @Override
            public void onFinish() {

            }
        }.start();

        timerRunning = true;
    }

    public void updateTimer() {
        int minutes = (int) timeLeftMilliseconds / 60000;
        int seconds = (int) timeLeftMilliseconds % 60000 / 1000;

        String timeLeftText;

        timeLeftText = "" + minutes;
        timeLeftText += "+";
        if (seconds < 10) timeLeftText += "0";
        timeLeftText += seconds;

        cdText.setText(timeLeftText);
    }
}
