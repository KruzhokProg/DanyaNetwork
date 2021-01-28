package com.example.danyanetwork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.danyanetwork.Model.Type;
import com.example.danyanetwork.Network.ApiClient;
import com.example.danyanetwork.Network.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiService apiService = ApiClient.getClient().create(ApiService.class);

        Call<List<Type>> call = apiService.getTypes();
        call.enqueue(new Callback<List<Type>>() {
            @Override
            public void onResponse(Call<List<Type>> call, Response<List<Type>> response) {
              List<Type> data = response.body();
              int i = 2;
            }

            @Override
            public void onFailure(Call<List<Type>> call, Throwable t) {

            }
        });

    }
}