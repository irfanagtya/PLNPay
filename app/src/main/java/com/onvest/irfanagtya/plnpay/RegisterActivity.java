package com.onvest.irfanagtya.plnpay;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {

    EditText nameReg, hpReg, emailReg, pwdReg,refReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //if the user is already logged in we will directly start the profile activity
        if (SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, HomeActivity.class));
            return;
        }

        nameReg = (EditText) findViewById(R.id.nameReg);
        hpReg = (EditText) findViewById(R.id.hpReg);
        emailReg = (EditText) findViewById(R.id.emailReg);
        pwdReg = (EditText) findViewById(R.id.pwdReg);
        refReg = (EditText) findViewById(R.id.refReg);

        findViewById(R.id.registerButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if user pressed on button register
                //here we will register the user to server
                registerUser();
            }
        });

        findViewById(R.id.loginTextButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if user pressed on login
                //we will open the login screen
                finish();
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });
    }

    private void registerUser() {
        final String nama_lengkap = nameReg.getText().toString().trim();
        final String no_hp = hpReg.getText().toString().trim();
        final String email = emailReg.getText().toString().trim();
        final String password = pwdReg.getText().toString().trim();
        final String kode_ref = refReg.getText().toString().trim();

        //first we will do the validations

        if (TextUtils.isEmpty(nama_lengkap)) {
            nameReg.setError("Masukkan nama lengkap anda");
            nameReg.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(no_hp)) {
            hpReg.setError("Masukkan nomor HP anda");
            hpReg.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(email)) {
            emailReg.setError("Masukkan email anda");
            emailReg.requestFocus();
            return;
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailReg.setError("Masukkan email dengan format yang benar");
            emailReg.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            pwdReg.setError("Masukkan password anda");
            pwdReg.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(kode_ref)) {
            refReg.setError("Masukkan kode referensi anda");
            refReg.requestFocus();
            return;
        }

        //if it passes all the validations
//        class RegisterUser extends AsyncTask<Void, Void, String> {
//
//            private ProgressBar progressBar;
//
//            @Override
//            protected String doInBackground(Void... voids) {
//                //creating request handler object
//                RequestHandler requestHandler = new RequestHandler();
//
//                //creating request parameters
//                HashMap<String, String> params = new HashMap<>();
//                params.put("nama_lengkap", nama_lengkap);
//                params.put("no_hp", no_hp);
//                params.put("email", email);
//                params.put("password", password);
//                params.put("kode_ref", kode_ref);
//
//                //returing the response
//                return requestHandler.sendPostRequest(URLs.URL_REGISTER, params);
//            }
//
//            @Override
//            protected void onPreExecute() {
//                super.onPreExecute();
//                //displaying the progress bar while user registers on the server
//                progressBar = (ProgressBar) findViewById(R.id.progressBar);
//                progressBar.setVisibility(View.VISIBLE);
//            }
//
//            @Override
//            protected void onPostExecute(String s) {
//                super.onPostExecute(s);
//                //hiding the progressbar after completion
//                progressBar.setVisibility(View.GONE);
//
//                try {
//                    //converting response to json object
//                    JSONObject obj = new JSONObject(s);
//
//                    //if no error in response
//                    if (!obj.getBoolean("error")) {
//                        Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();
//
//                        //getting the user from the response
//                        JSONObject userJson = obj.getJSONObject("user");
//
//                        //creating a new user object
//                        User user = new User(
//                                userJson.getInt("id_user"),
//                                userJson.getString("nama_lengkap"),
//                                userJson.getString("no_hp"),
//                                userJson.getString("email"),
//                                userJson.getString("kode_ref")
//                        );
//
//                        //storing the user in shared preferences
//                        SharedPrefManager.getInstance(getApplicationContext()).userLogin(user);
//
//                        //starting the profile activity
//                        finish();
//                        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
//                    } else {
//                        Toast.makeText(getApplicationContext(), "Some error occurred", Toast.LENGTH_SHORT).show();
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//        //executing the async task
//        RegisterUser ru = new RegisterUser();
//        ru.execute();

    }
}
