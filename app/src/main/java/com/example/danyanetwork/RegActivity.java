package com.example.danyanetwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.Toast;

import com.example.danyanetwork.Model.History;
import com.example.danyanetwork.Model.RegInfo;
import com.example.danyanetwork.Model.UserInfo;
import com.example.danyanetwork.Network.ApiClient;
import com.example.danyanetwork.Network.ApiService;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegActivity extends AppCompatActivity {

    EditText etUserId, etAdId;
    CheckBox cbSeen, cbLiked;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        etUserId = findViewById(R.id.etUserId);
        etAdId = findViewById(R.id.etAdId);
        cbSeen = findViewById(R.id.cbSeen);
        cbLiked = findViewById(R.id.cbLiked);
        sharedPref = getSharedPreferences("test", Context.MODE_PRIVATE);

        editor = sharedPref.edit();
        String email = sharedPref.getString("email","");
        String pass = sharedPref.getString("pass","");
        if(!email.equals("") && !pass.equals("")){
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
    }

    public void onRegClick(View view) {
        editor = sharedPref.edit();
        String email = etUserId.getText().toString();
        String password = etAdId.getText().toString();
        editor.putString("email", email);
        editor.putString("pass", password);
        editor.apply();
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
//        RegInfo user = new RegInfo();
//        user.setEmail("test2021@mail.ru");
//        user.setCompanyName("school998");
//        user.setPassword("123456");
//        user.setPhoneNumber("532476523");
//        user.setRoleId(1);
//
//        ApiService apiService = ApiClient.getClient().create(ApiService.class);
//        Call<ResponseBody> call = apiService.createUser(user);
//        call.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                if(response.code() == 200){
//                    Toast.makeText(RegActivity.this, "Ok!", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                Toast.makeText(RegActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    public void onPostHistoryClick(View view) {

        History h = new History();
        Integer userId = Integer.parseInt(etUserId.getText().toString());
        Integer adId = Integer.parseInt(etAdId.getText().toString());
        Boolean seen = cbSeen.isChecked();
        Boolean liked = cbLiked.isChecked();
        h.setAdId(adId);
        h.setUserId(userId);
        h.setSeen(seen);
        h.setLiked(liked);

        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<ResponseBody> call = apiService.addHistory(h);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Toast.makeText(RegActivity.this, "Success: " + String.valueOf(response.code()), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(RegActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}