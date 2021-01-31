package com.example.danyanetwork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.danyanetwork.Model.RegInfo;
import com.example.danyanetwork.Model.UserInfo;
import com.example.danyanetwork.Network.ApiClient;
import com.example.danyanetwork.Network.ApiService;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
    }

    public void onRegClick(View view) {
        RegInfo user = new RegInfo();
        user.setEmail("test2021@mail.ru");
        user.setCompanyName("school998");
        user.setPassword("123456");
        user.setPhoneNumber("532476523");
        user.setRoleId(1);

        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<ResponseBody> call = apiService.createUser(user);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.code() == 200){
                    Toast.makeText(RegActivity.this, "Ok!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(RegActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}