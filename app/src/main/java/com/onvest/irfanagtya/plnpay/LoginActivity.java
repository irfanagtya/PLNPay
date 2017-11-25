package com.onvest.irfanagtya.plnpay;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.onvest.irfanagtya.plnpay.model.request.LoginRequest;
import com.onvest.irfanagtya.plnpay.model.response.LoginResponse;
import com.onvest.irfanagtya.plnpay.network.RestService;
import com.onvest.irfanagtya.plnpay.utils.PrefManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = LoginActivity.class.getSimpleName();

    EditText emailLogin, pwdLogin;
    ProgressBar progressBar;
    RestService restService;
    PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailLogin = findViewById(R.id.emailLogin);
        pwdLogin = findViewById(R.id.pwdLogin);
        progressBar = findViewById(R.id.progressBar);
        restService = new RestService();
        prefManager = new PrefManager(this);

        if (prefManager.isLoggedIn()) {
            startActivity(new Intent(this, HomeActivity.class));
        }


        //if user presses on login
        //calling the method login
        findViewById(R.id.loginButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userLogin();
            }
        });

        //if user presses on not registered
        findViewById(R.id.registerTextButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "register clicked");
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }

    private void userLogin() {
        //first getting the values
        final String email = emailLogin.getText().toString();
        final String password = pwdLogin.getText().toString();

        //validating inputs
        if (TextUtils.isEmpty(email)) {
            emailLogin.setError("Masukkan email anda");
            emailLogin.requestFocus();
            return;
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailLogin.setError("Masukkan email dengan format yang benar");
            emailLogin.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            pwdLogin.setError("Masukkan password anda");
            pwdLogin.requestFocus();
            return;
        }

        LoginRequest request = new LoginRequest(email, password);
        progressBar.setVisibility(View.VISIBLE);
        restService.login(new RestService.PlnCallback<LoginResponse>() {
            @Override
            public void onSuccess(LoginResponse response) {
                User user = new User(response.getUser().getIdUser(), response.getUser().getName(),
                        response.getUser().getPhone(), response.getUser().getEmail(),
                        response.getUser().getRef());
                prefManager.saveUser(user);
                prefManager.setLogin(true);
                progressBar.setVisibility(View.GONE);
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            }

            @Override
            public void onError(int errorCode) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
            }
        }, request);
    }
}
