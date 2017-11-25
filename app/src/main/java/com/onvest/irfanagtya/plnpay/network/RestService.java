package com.onvest.irfanagtya.plnpay.network;

import android.util.Log;

import com.google.gson.Gson;
import com.onvest.irfanagtya.plnpay.model.request.LoginRequest;
import com.onvest.irfanagtya.plnpay.model.response.LoginResponse;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by shoddiq on 25/11/17.
 */

public class RestService {
    private static final String TAG = RestService.class.getSimpleName();
    private static final String BASE_URL = "http://192.168.100.5/plnpay/";
    private NetworkService networkService;

    public RestService() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
        Gson gson = new Gson();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient)
                .build();
        networkService = retrofit.create(NetworkService.class);
    }

    public void login(final PlnCallback<LoginResponse> callback, LoginRequest request) {
        networkService.login(request.getEmail(), request.getPassword()).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, response.body().toString());
                    callback.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
    }


    public interface PlnCallback<T> {
        void onSuccess(T response);

        void onError(int errorCode);
    }
}
