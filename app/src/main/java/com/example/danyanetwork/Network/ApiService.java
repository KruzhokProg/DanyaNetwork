package com.example.danyanetwork.Network;

import com.example.danyanetwork.Model.RegInfo;
import com.example.danyanetwork.Model.Type;
import com.example.danyanetwork.Model.UserInfo;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @GET("type")
    Call<List<Type>> getTypes();
    @GET("userinfo")
    Call<List<UserInfo>> getUsers();
    @POST("Registration")
    Call<ResponseBody> createUser(@Body RegInfo user);
}
