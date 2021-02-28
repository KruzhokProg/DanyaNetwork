package com.example.danyanetwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.danyanetwork.Model.CheckUser;
import com.example.danyanetwork.Network.ApiClient;
import com.example.danyanetwork.Network.ApiService;

import java.util.List;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Auth extends AppCompatActivity {
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[0-9])" +         //at least 1 digit
                    //"(?=.*[a-z])" +         //at least 1 lower case letter
                    //"(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    //"(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{6,}" +               //at least 4 characters
                    "$");

    EditText etEmail, etPass;
    Button btnNext;
    boolean isEmailValid, isPassValid;
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        etEmail = findViewById(R.id.etEmailReg);
        etPass = findViewById(R.id.etPassReg);
        btnNext = findViewById(R.id.btnNextReg);
        btnNext.setClickable(false);
        isEmailValid = false;
        isPassValid = false;


        etEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String emailInput = etEmail.getEditableText().toString().trim();

                if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches() && isPassValid == false)
                {
                    btnNext.setClickable(false);
                    btnNext.setBackgroundColor(getResources().getColor(R.color.btnNextInvalidColorBack));
                    btnNext.setTextColor(getResources().getColor(R.color.btnNextInvalidTextColor));
                    isEmailValid = false;
                    etEmail.setError("Неверный email");
                }

                else if (emailInput.isEmpty() && isPassValid == false) {
                    btnNext.setClickable(false);
                    btnNext.setBackgroundColor(getResources().getColor(R.color.btnNextInvalidColorBack));
                    btnNext.setTextColor(getResources().getColor(R.color.btnNextInvalidTextColor));
                    isEmailValid = false;
                    etEmail.setError("Поле не может быть пустое");
                }

                else if (Patterns.EMAIL_ADDRESS.matcher(emailInput).matches() && isPassValid == false)
                {
                    btnNext.setClickable(false);
                    btnNext.setBackgroundColor(getResources().getColor(R.color.btnNextInvalidColorBack));
                    btnNext.setTextColor(getResources().getColor(R.color.btnNextInvalidTextColor));
                    isEmailValid = false;
                    etEmail.setError(null);
                }
                else{
                    btnNext.setClickable(true);
                    btnNext.setBackgroundColor(getResources().getColor(R.color.btnNextValidColorBack));
                    btnNext.setTextColor(getResources().getColor(R.color.white));
                    isEmailValid = true;
                    etEmail.setError(null);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etPass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                isPassValid = false;
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String passwordInput = etPass.getEditableText().toString().trim();

                if (passwordInput.isEmpty()) {
                    btnNext.setClickable(false);
                    btnNext.setBackgroundColor(getResources().getColor(R.color.btnNextInvalidColorBack));
                    btnNext.setTextColor(getResources().getColor(R.color.btnNextInvalidTextColor));
                    isPassValid = false;
                    etPass.setError("Поле не может быть пустое");
                } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
                    btnNext.setClickable(false);
                    btnNext.setBackgroundColor(getResources().getColor(R.color.btnNextInvalidColorBack));
                    btnNext.setTextColor(getResources().getColor(R.color.btnNextInvalidTextColor));
                    isPassValid = false;
                    etPass.setError("Пароль слишком слабый");
                } else {
                    btnNext.setClickable(true);
                    btnNext.setBackgroundColor(getResources().getColor(R.color.btnNextValidColorBack));
                    btnNext.setTextColor(getResources().getColor(R.color.white));
                    isPassValid = true;
                    etPass.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


    public void OnClickRegAuth(View view)
    {
        Intent i = new Intent(this, ActivityReg.class);
        startActivity(i);
    }

    public void NextClick(View view)
    {
        String email = etEmail.getText().toString();
        String password = etPass.getText().toString();

        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<Integer> call = apiService.getUser(email, password);
        call.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                Integer id = response.body();
                if(id != -1){

                    sharedPref = getSharedPreferences("userInfo", MODE_PRIVATE);
                    SharedPreferences.Editor edit = sharedPref.edit();
                    edit.putInt("userId", id);
                    edit.apply();

                    Intent i = new Intent(Auth.this, NavigationActivity.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(Auth.this, "Ошибка входа", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {

            }
        });

    }

    public void openBottomMenuClick(View view) {
        Intent i = new Intent(this, NavigationActivity.class);
        startActivity(i);
    }
}