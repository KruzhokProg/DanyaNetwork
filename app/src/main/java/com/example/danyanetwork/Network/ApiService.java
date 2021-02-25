package com.example.danyanetwork.Network;

import com.example.danyanetwork.Model.CheckUser;
import com.example.danyanetwork.Model.History;
import com.example.danyanetwork.Model.RegInfo;
import com.example.danyanetwork.Model.Type;
import com.example.danyanetwork.Model.UserInfo;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    @GET("type")
    Call<List<Type>> getTypes();

    @GET("userinfo")
    Call<List<UserInfo>> getUsers();

    @GET("checkuser")
    Call<List<CheckUser>> getUser();

    @POST("Registration")
    Call<ResponseBody> createUser(@Body RegInfo user);

    @POST("history")
    Call<ResponseBody> addHistory(@Body History history);

    @DELETE("history")
    Call<ResponseBody> clearHistory(@Query("userId") Integer userId);
}
