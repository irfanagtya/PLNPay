package com.onvest.irfanagtya.plnpay.network;

import com.onvest.irfanagtya.plnpay.model.response.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by shoddiq on 25/11/17.
 */

public interface NetworkService {
    @FormUrlEncoded
    @POST("api.php?apicall=login")
    Call<LoginResponse> login(@Field("email") String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("api.php?apicall=signup")
    Call<LoginResponse> signup(@Field("nama_lengkap") String name, @Field("no_hp") String phone,
                               @Field("email") String email, @Field("password") String password,
                               @Field("kode_ref") int ref);
}
