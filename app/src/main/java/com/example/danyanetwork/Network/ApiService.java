package com.example.danyanetwork.Network;

import com.example.danyanetwork.Model.Type;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("type")
    Call<List<Type>> getTypes();
}
