package com.example.danyanetwork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Auth extends AppCompatActivity {

    EditText etEmail, etPass;
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etPass);
        btnNext = findViewById(R.id.btnNext);
        btnNext.setClickable(false);

        etEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if( s.toString().contains("@") && s.toString().contains(".")){
                    btnNext.setClickable(true);
                    btnNext.setBackgroundColor(getResources().getColor(R.color.btnNextValidColorBack));
                    btnNext.setTextColor(getResources().getColor(R.color.white));
                }
                else{
                    btnNext.setClickable(false);
                    btnNext.setBackgroundColor(getResources().getColor(R.color.btnNextInvalidColorBack));
                    btnNext.setTextColor(getResources().getColor(R.color.btnNextInvalidTextColor));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void btnNextClick(View view) {
    }
}