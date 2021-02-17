package com.example.danyanetwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.danyanetwork.Model.Type;
import com.example.danyanetwork.Model.UserInfo;
import com.example.danyanetwork.Network.ApiClient;
import com.example.danyanetwork.Network.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView tvRes;
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //tvRes = findViewById(R.id.tvRes);
        sharedPref = getSharedPreferences("test",Context.MODE_PRIVATE);
        //int defaultValue = getResources().getInteger(R.integer.saved_high_score_default_key);
        String email = sharedPref.getString("email","");
        String pass = sharedPref.getString("pass","");
        tvRes.setText(email + " " + pass);

//        ApiService apiService = ApiClient.getClient().create(ApiService.class);
//
//        Call<List<UserInfo>> call = apiService.getUsers();
//        call.enqueue(new Callback<List<UserInfo>>() {
//            @Override
//            public void onResponse(Call<List<UserInfo>> call, Response<List<UserInfo>> response) {
//                List<UserInfo> data = response.body();
//                int i=2;
//            }
//
//            @Override
//            public void onFailure(Call<List<UserInfo>> call, Throwable t) {
//
//            }
//        });

//        Call<List<Type>> call = apiService.getTypes();
//        call.enqueue(new Callback<List<Type>>() {
//            @Override
//            public void onResponse(Call<List<Type>> call, Response<List<Type>> response) {
//              List<Type> data = response.body();
//              int i = 2;
//            }
//
//            @Override
//            public void onFailure(Call<List<Type>> call, Throwable t) {
//
//            }
//        });

    }

    public void btnOutClick(View view) {
        sharedPref = getSharedPreferences("test",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("email", "");
        editor.putString("pass", "");
        editor.apply();
        Intent i = new Intent(this, RegActivity.class);
        startActivity(i);
    }
}